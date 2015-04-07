package cn.johnson.algorithm.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@SuppressWarnings("rawtypes")
public class MyclassLoader extends ClassLoader {

	public Class load(String name) throws ClassNotFoundException {

		String classPath = getClass().getResource("/").getPath();
		String fileName = name.replace(".", "/") + ".class";
		File classFile = new File(classPath, fileName);

		if (!classFile.exists()) {
			throw new ClassNotFoundException(classFile.getPath() + " 不存在");
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ByteBuffer bf = ByteBuffer.allocate(1024);
		FileInputStream fis = null;
		FileChannel fc = null;
		try {
			fis = new FileInputStream(classFile);
			fc = fis.getChannel();
			while (fc.read(bf) > 0) {
				bf.flip();
				bos.write(bf.array(), 0, bf.limit());
				bf.clear();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return defineClass(bos.toByteArray(), 0, bos.toByteArray().length);

	}

}
