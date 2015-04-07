package cn.johnson.algorithm.test;

import java.io.IOException;
import java.lang.reflect.Method;

public class DoopRun {

	private CVersion cversion;

	public static void main(String[] args) {
		DoopRun doopRun = new DoopRun();
		doopRun.setCversion(new CVersionA());
		for (int i = 0; i < 10; i++) {
			if (i == 3) {

				try {
					System.in.read();
				} catch (IOException e1) {
					e1.printStackTrace();
				}

				// hot swap
				try {
					Class<?> classB = new MyclassLoader()
							.load("cn.johnson.algorithm.test.CVersionA");

					Method method = doopRun.getClass().getMethod("setCversion",
							CVersion.class);
					Object jObject = classB.newInstance();

					CVersion cVersion = (CVersion) classB.newInstance();

					CVersionA cVersiona = (CVersionA) classB.newInstance();

					method.invoke(doopRun, classB.newInstance());

					Method getMethod = doopRun.getClass().getMethod(
							"getCversion");

					Object binstance = getMethod.invoke(doopRun);

					System.out.println(binstance.getClass().getClassLoader());

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			doopRun.cversion.sayHello();
		}
	}

	public void setCversion(CVersion cversion) {
		this.cversion = cversion;
	}

	public CVersion getCversion() {
		return cversion;
	}

}
