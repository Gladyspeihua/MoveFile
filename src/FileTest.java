import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		FileTest fileTest = new FileTest();
		for (int CD = 301; CD <= 325; CD++) {

			for (int year = 1997; year <= 2010; year++) {

				String frompath1 = "D:/學校/Hua/Cohort2012/R" + CD + "_" + year;

				fileTest.moveFile(frompath1, "D:/學校/Hua/Cohort2012/DD");//要改
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
			if (file.getName().matches(".+" + "_DD" + "[0-9]+" + ".DAT")) {//要改
				if (file.isDirectory()) {
					moveFile(file.getPath(), toPath + "\\" + file.getName());
					// 亦可刪除
					// file.delete();
				}
				if (file.isFile()) {
					File toFile = new File(toFolder + "\\" + file.getName());
					if (toFile.exists()) {
						// 亦可刪除
						// toFile.delete();
					}
					// 移動文件
					file.renameTo(toFile);
				}

			}

		}
	}

}
