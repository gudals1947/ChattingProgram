package ChattingSouce;

import javax.swing.UIManager;

import UI.Form;

public class ChattingMain {
	public static void main(String ary[]) {
		// 1. 자바 내장 룩앤필

		// UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		// 2. quaqua.jar : Quaqua Look and Feel
		try {
			 UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}

		// 3. liquidlnf.jar : Liquid Look and Feel

		// UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");

		// 4. idw-gpl.jar : InfoNode Look and Feel

		// UIManager.setLookAndFeel("net.infonode.gui.laf.InfoNodeLookAndFeel");

		// 5. JTattoo.jar : JTattoo Look and Feel

		// UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

		// UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		new Form();
	}
}
