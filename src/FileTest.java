import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		FileTest fileTest = new FileTest();
		for (int CD = 301; CD <= 325; CD++) {

			for (int year = 1997; year <= 2010; year++) {

				String frompath1 = "D:/�Ǯ�/Hua/Cohort2012/R" + CD + "_" + year;

				fileTest.moveFile(frompath1, "D:/�Ǯ�/Hua/Cohort2012/DD");//�n��
			}
		}
	}

	public void moveFile(String fromPath, String toPath) {
		File fromFolder = new File(fromPath);
		File[] fromFiles = fromFolder.listFiles();
		if (fromFiles == null) {
			return;
		}
		File toFolder = new File(toPath);
		if (!toFolder.exists()) {
			toFolder.mkdirs();
		}
		for (int i = 0; i < fromFiles.length; i++) {
			File file = fromFiles[i];
			if (file.getName().matches(".+" + "_DD" + "[0-9]+" + ".DAT")) {//�n��
				if (file.isDirectory()) {
					moveFile(file.getPath(), toPath + "\\" + file.getName());
					// ��i�R��
					// file.delete();
				}
				if (file.isFile()) {
					File toFile = new File(toFolder + "\\" + file.getName());
					if (toFile.exists()) {
						// ��i�R��
						// toFile.delete();
					}
					// ���ʤ��
					file.renameTo(toFile);
				}

			}

		}
	}

}
