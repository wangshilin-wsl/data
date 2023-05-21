package xianyu.client;

import javax.swing.JOptionPane;

public class CheckPassword {

	/**
	 * 密码强度
	 *
	 * @return Z = 字母 S = 数字 T = 特殊字符
	 */
	public String checkPassword(String passwordStr) {
		String regexZ = "\\d*";
		String regexS = "[a-zA-Z]+";
		String regexT = "\\W+$";
		String regexZT = "\\D*";
		String regexST = "[\\d\\W]*";
		String regexZS = "\\w*";
		String regexZST = "[\\w\\W]*";

		if (passwordStr.matches(regexZ)) {
			JOptionPane.showMessageDialog(null, "password强度弱");
			return "弱";
		}
		if (passwordStr.matches(regexS)) {
			JOptionPane.showMessageDialog(null, "password强度弱");
			return "弱";
		}
		if (passwordStr.matches(regexT)) {
			JOptionPane.showMessageDialog(null, "password强度弱");
			return "弱";
		}
		if (passwordStr.matches(regexZT)) {
			JOptionPane.showMessageDialog(null, "password强度中");
			return "中";
		}
		if (passwordStr.matches(regexST)) {
			JOptionPane.showMessageDialog(null, "password强度中");
			return "中";
		}
		if (passwordStr.matches(regexZS)) {
			JOptionPane.showMessageDialog(null, "password强度中");
			return "中";
		}
		if (passwordStr.matches(regexZST)) {
			JOptionPane.showMessageDialog(null, "password强度强");
			return "强";
		}
		return passwordStr;

	}
}