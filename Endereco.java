import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

public class Endereco {
	public URL GetEndereco() throws MalformedURLException {

		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        jfc.setFileFilter(new FileFilter() {
            public String getDescription() {
                return "HTM Files (*.htm)";
            }

        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            } else {
                String filename = f.getName().toLowerCase();
                return filename.endsWith(".htm");
        }
    }
});

		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			return selectedFile.toURI().toURL();
		}
		return null;

	}

}