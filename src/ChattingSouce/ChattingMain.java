package ChattingSouce;

import javax.swing.UIManager;

import UI.Form;

public class ChattingMain {
	public static void main(String ary[]) {
		try {
			 UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}

		new Form();
	}
}
