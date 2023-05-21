package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Random;

/**
 * 2010-7-9 ����09:42:10
 * <p>
 * ����ѡ����<br>
 * ʹ�÷���: 1.����JCalendarChooser����;<br>
 * 2.����showCalendarDialog()������ȡѡ���Calendar����
 * 
 * @author mkk(monkeyking1987@126.com)
 * @version 1.0
 * @see JFileChooser
 */
public class JCalendarChooser extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;

	/**
	 * ������<br>
	 * �ڴ�����������showCalendarDialog()������ȡѡ�������ֵ
	 * 
	 * @param parent
	 *            �����
	 */
	public JCalendarChooser(Frame parent) {
		super(parent, true);
		this.setTitle(title);
		// init
		this.initDatas();
	}

	/**
	 * ������<br>
	 * �ڴ�����������showCalendarDialog()������ȡѡ�������ֵ
	 * 
	 * @param parent
	 *            �����
	 * @param title
	 *            ����
	 */
	public JCalendarChooser(Frame parent, String title) {
		super(parent, title, true);
		// init
		this.initDatas();
	}

	/**
	 * ������<br>
	 * �ڴ�����������showCalendarDialog()������ȡѡ�������ֵ
	 * 
	 * @param parent
	 *            �����
	 * @param title
	 *            ����
	 * @param location
	 *            ������ʾ��λ������
	 */
	public JCalendarChooser(Frame parent, String title, Point location) {
		super(parent, title, true);
		this.location = location;
		// init
		this.initDatas();
	}

	/**
	 * ������<br>
	 * �ڴ�����������showCalendarDialog()������ȡѡ�������ֵ
	 * 
	 * @param parent
	 *            �����
	 * @param title
	 *            ����
	 * @param location
	 *            ������ʾ��λ������
	 * @param showYears
	 *            ��ʾ������ֵ,Ĭ��Ϊ��ʾ100��,��ǰ��50��<br>
	 *            ���� ��ǰ���Ϊ2010��,����showYearsΪ30��,�������ʾ�����������ֵ��1995-2024<br>
	 *            ע��: ��showYearsֵ�������0,����ʹ��Ĭ������ֵ
	 */
	public JCalendarChooser(Frame parent, String title, Point location,
			int showYears) {
		super(parent, title, true);
		this.location = location;
		if (showYears > 0) {
			this.showYears = showYears;
		}
		// init
		this.initDatas();
	}

	/**
	 * ������<br>
	 * �ڴ�����������showCalendarDialog()������ȡѡ�������ֵ
	 * 
	 * @param parent
	 *            �����
	 */
	public JCalendarChooser(Dialog parent) {
		super(parent, true);
		this.setTitle(title);
		// init
		this.initDatas();
	}

	/**
	 * ������<br>
	 * �ڴ�����������showCalendarDialog()������ȡѡ�������ֵ
	 * 
	 * @param parent
	 *            �����
	 * @param title
	 *            ����
	 */
	public JCalendarChooser(Dialog parent, String title) {
		super(parent, title, true);
		// init
		this.initDatas();
	}

	/**
	 * ������<br>
	 * �ڴ�����������showCalendarDialog()������ȡѡ�������ֵ
	 * 
	 * @param parent
	 *            �����
	 * @param title
	 *            ����
	 * @param location
	 *            ������ʾ��λ������
	 */
	public JCalendarChooser(Dialog parent, String title, Point location) {
		super(parent, title, true);
		this.location = location;
		// init
		this.initDatas();
	}

	/**
	 * ������<br>
	 * �ڴ�����������showCalendarDialog()������ȡѡ�������ֵ
	 * 
	 * @param parent
	 *            �����
	 * @param title
	 *            ����
	 * @param location
	 *            ������ʾ��λ������
	 * @param showYears
	 *            ��ʾ������ֵ,Ĭ��Ϊ��ʾ100��,��ǰ��50��<br>
	 *            ���� ��ǰ���Ϊ2010��,����showYearsΪ30��,�������ʾ�����������ֵ��1995-2024<br>
	 *            ע��: ��showYearsֵ�������0,����ʹ��Ĭ������ֵ
	 */
	public JCalendarChooser(Dialog parent, String title, Point location,
			int showYears) {
		super(parent, title, true);
		this.setTitle(title);
		this.location = location;
		if (showYears > 0) {
			this.showYears = showYears;
		}
		// init
		this.initDatas();
	}

	/**
	 * 
	 * @param width
	 *            ����
	 * @param height
	 *            ���
	 * @return
	 */
	private Dimension getStartDimension(int width, int height) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		dim.width = dim.width / 2 - width / 2;
		dim.height = dim.height / 2 - height / 2;
		return dim;
	}

	/**
	 * ��ʼ������
	 */
	private void initDatas() {
		this.chooser = this;
		this.mdcEvent = new MouseDoubleClickedEvent();
		this.calendar = Calendar.getInstance();
		this.year1 = this.calendar.get(Calendar.YEAR);
		this.month1 = this.calendar.get(Calendar.MONTH);
		this.day1 = this.calendar.get(Calendar.DAY_OF_MONTH);
		this.years = new String[showYears];
		this.months = new String[12];
		// init label1
		label1 = new JLabel();
		label1.setForeground(Color.MAGENTA);
		// init months
		for (int i = 0; i < this.months.length; i++) {
			this.months[i] = " " + formatDay(i + 1);
		}
		// init years
		int start = this.year1 - this.showYears / 2;
		for (int i = start; i < start + showYears; i++) {
			this.years[i - start] = String.valueOf(i);
		}
		// show info
		this.setInfo(this.year1 + "-" + this.formatDay(this.month1 + 1) + "-"
				+ formatDay(this.day1) + "            ", Color.BLUE);

	}

	/**
	 * ��ʾDialog�ķ���
	 */
	private void showDialog() {
		// ���ò���
		setLayout(new BorderLayout());
		// �������
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		showNorthPanel(panel3);
		add(panel3, BorderLayout.NORTH);
		// �м����
		add(printCalendar(), BorderLayout.CENTER);
		// �ϱ����
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.showSouthPanel(panel2);
		add(panel2, BorderLayout.SOUTH);
		// ���ô�С
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// ������ʾ��λ��
		if (this.location == null) {
			Dimension dim = getStartDimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
			setLocation(dim.width, dim.height);
		} else {
			setLocation(this.location);
		}
		setVisible(true);
	}

	/**
	 * ��ʾ�������
	 * 
	 * @param panel
	 */
	private void showNorthPanel(JPanel panel) {
		this.button2 = new JButton("��һ��");
		this.button2.setToolTipText("��һ��");
		this.button2.addActionListener(this);
		panel.add(this.button2);
		this.comboBox1 = new JComboBox(this.years);
		this.comboBox1.setSelectedItem(String.valueOf(year1));
		this.comboBox1.setToolTipText("���");
		this.comboBox1.setActionCommand("year");
		this.comboBox1.addActionListener(this);
		panel.add(this.comboBox1);
		this.comboBox2 = new JComboBox(this.months);
		this.comboBox2.setSelectedItem(" " + formatDay(month1 + 1));
		this.comboBox2.setToolTipText("�·�");
		this.comboBox2.setActionCommand("month");
		this.comboBox2.addActionListener(this);
		panel.add(this.comboBox2);
		this.button3 = new JButton("��һ��");
		this.button3.setToolTipText("��һ��");
		this.button3.addActionListener(this);
		panel.add(this.button3);
	}

	/**
	 * ��ʾ�ϱ������Ϣ
	 * 
	 * @param panel
	 */
	private void showSouthPanel(JPanel panel) {
		// ״̬��
		panel.add(label1);
		this.button1 = new JButton("ȷ��");
		this.button1.setToolTipText("ȷ��");
		this.button1.addActionListener(this);
		panel.add(button1);
		panel.add(new JLabel(" "));
	}

	/**
	 * �ڹ���������ô˷�����ȡѡ�������ֵ
	 * 
	 * @return ѡ����������Calendar
	 */
	public Calendar showCalendarDialog() {
		this.showDialog();
		return this.calendar;
	}

	/**
	 * ״̬����ʾ
	 * 
	 * @param info
	 */
	private void setInfo(String info, Color c) {
		if (this.label1 != null && c != null) {
			this.label1.setText(info);
			this.label1.setForeground(c);
		}
	}

	/**
	 * ������ʾ������,��С��10����ǰ���0
	 * 
	 * @param day
	 * @return
	 */
	private String formatDay(int day) {
		if (day < 10) {
			return "0" + day;
		}
		return String.valueOf(day);
	}

	/**
	 * ������ڵ����
	 *
	 * @return
	 */
	private JPanel printCalendar() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(7, 7, 0, 0));
		panel.setBorder(BorderFactory.createRaisedBevelBorder());
		int year2 = calendar.get(Calendar.YEAR);
		int month2 = calendar.get(Calendar.MONTH);
		// ��������Ϊ���µ�һ��
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		// ��ȡ��һ�������ڼ�
		int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
		// ��ӡ��ͷ
		JButton b = null;
		for (int i = 0; i < tits.length; i++) {
			b = new JButton("<html><b>" + tits[i] + "</b></html>");
			b.setForeground(Color.BLACK);
			b.setBackground(Color.WHITE);
			b.setBorder(BorderFactory.createEmptyBorder());
			b.setEnabled(false);
			panel.add(b);
		}
		int count = 0;
		for (int i = Calendar.SUNDAY; i < weekDay; i++) {
			b = new JButton(" ");
			b.setEnabled(false);
			panel.add(b);
			count++;
		}
		int currday = 0;
		String dayStr = null;
		do {
			currday = calendar.get(Calendar.DAY_OF_MONTH);
			dayStr = formatDay(currday);
			// ��,��,���������ʾ
			if (currday == day1 && month1 == month2 && year1 == year2) {
				b = new JButton("[" + dayStr + "]");
				b.setForeground(Color.RED);
			} else {
				b = new JButton(dayStr);
				b.setForeground(Color.BLUE);
			}
			count++;
			b
					.setToolTipText(year2 + "-" + formatDay(month2 + 1) + "-"
							+ dayStr);
			b.setBorder(BorderFactory.createEtchedBorder());
			b.addActionListener(this);
			b.addMouseListener(this.mdcEvent);
			panel.add(b);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			// ѭ�����ʱ�·�ʵ�����Ѿ���1
		} while (calendar.get(Calendar.MONTH) == month2);
		// ��1,����Ϊ��ǰ��
		this.calendar.add(Calendar.MONTH, -1);
		if (!flag) {
			// ��������Ϊ����
			this.calendar.set(Calendar.DAY_OF_MONTH, this.day1);
			flag = true;
		}
		for (int i = count; i < 42; i++) {
			b = new JButton(" ");
			b.setEnabled(false);
			panel.add(b);
		}
		return panel;
	}

	/**
	 * �ڲ���,���ڼ������ڰ�ť��˫���¼� 2010-7-10 ����11:34:26
	 */
	private class MouseDoubleClickedEvent extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (MouseEvent.BUTTON1 == e.getButton()) {
				if (e.getClickCount() == 2) {
					// ������˫���¼�
					JButton b = (JButton) e.getSource();
					String s = b.getText();
					if (s.matches("^\\d+$")) {
						int day = Integer.parseInt(s);
						calendar.set(Calendar.DAY_OF_MONTH, day);
					} else if (s.startsWith("[")) {
						calendar.set(Calendar.DAY_OF_MONTH, day1);
					}
					// dispose
					chooser.dispose();
				}
			}
		}

	}

	/**
	 * ���½���
	 */
	private void updatePanel() {
		this.remove(this.panel);
		this.add(this.printCalendar(), BorderLayout.CENTER);
		this.validate();
	}

	/**
	 * ��Ӧ����¼�
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if ("��һ��".equals(command)) {
			// 1.�·ݼ�һ
			this.calendar.add(Calendar.MONTH, 1);
			// 2.������ʾ��������
			int year5 = calendar.get(Calendar.YEAR);
			// �ж��Ƿ񳬳���ʾ�����Χ
			int maxYear = this.year1 + this.showYears / 2 - 1;
			if (year5 > maxYear) {
				this.calendar.add(Calendar.MONTH, -1);
				this.setInfo("���Խ��: [" + year5 + " > " + maxYear + "]      ",
						Color.RED);
				return;
			}
			int month5 = calendar.get(Calendar.MONTH) + 1;
			this.comboBox1.setSelectedItem(String.valueOf(year5));
			this.comboBox2.setSelectedItem(" " + this.formatDay(month5));
			// 3.���½���
			this.updatePanel();
		} else if ("��һ��".equals(command)) {
			// 1.�·ݼ�һ
			this.calendar.add(Calendar.MONTH, -1);
			// 2.������ʾ��������
			int year5 = calendar.get(Calendar.YEAR);
			// �ж��Ƿ񳬳���ʾ�����Χ
			int minYear = this.year1 - this.showYears / 2;
			if (year5 < minYear) {
				this.calendar.add(Calendar.MONTH, 1);
				this.setInfo("���Խ��: [" + year5 + " < " + minYear + "]      ",
						Color.RED);
				return;
			}
			int month5 = calendar.get(Calendar.MONTH) + 1;
			this.comboBox1.setSelectedItem(String.valueOf(year5));
			this.comboBox2.setSelectedItem(" " + this.formatDay(month5));
			// 3.���½���
			this.updatePanel();
		} else if ("ȷ��".equals(command)) {
			chooser.dispose();
		} else if (command.matches("^\\d+$")) {
			// ѡ��һ����������ڵ��¼�
			int day9 = Integer.parseInt(command);
			this.calendar.set(Calendar.DAY_OF_MONTH, day9);
			String str = this.calendar.get(Calendar.YEAR) + "-"
					+ this.formatDay(this.calendar.get(Calendar.MONTH) + 1)
					+ "-"
					+ this.formatDay(this.calendar.get(Calendar.DAY_OF_MONTH));
			this.setInfo(str + "            ", getRandomColor());
		} else if (command.startsWith("[")) {
			// ����Ϊ��ǰ���ڵ����
			this.calendar.set(Calendar.DAY_OF_MONTH, this.day1);
			String str = this.calendar.get(Calendar.YEAR) + "-"
					+ this.formatDay(this.calendar.get(Calendar.MONTH) + 1)
					+ "-"
					+ this.formatDay(this.calendar.get(Calendar.DAY_OF_MONTH));
			this.setInfo(str + "            ", getRandomColor());
		} else if ("year".equalsIgnoreCase(command)) {
			// ѡ�����¼�
			int value = Integer.parseInt(this.comboBox1.getSelectedItem()
					.toString().trim());
			this.calendar.set(Calendar.YEAR, value);
			this.updatePanel();
		} else if ("month".equalsIgnoreCase(command)) {
			// ѡ�����¼�
			int value = Integer.parseInt(this.comboBox2.getSelectedItem()
					.toString().trim());
			this.calendar.set(Calendar.MONTH, value - 1);
			this.updatePanel();
		}
	}

	/**
	 * ��ȡһ���������ɫֵ
	 * 
	 * @return
	 */
	private Color getRandomColor() {
		Random random = new Random();
		Color c = new Color(random.nextInt(255), random.nextInt(255), random
				.nextInt(255));
		return c;
	}

	// Ĭ�Ͽ����߶�
	private static final int DEFAULT_WIDTH = 285;
	private static final int DEFAULT_HEIGHT = 280;
	// Ĭ����ʾ�����Ϊ100��,�������ǰ��50��
	private int showYears = 100;
	// ״̬����ȷ�ϰ�ť
	// ״̬��������17������
	private JLabel label1 = null;
	private JButton button1 = null;
	// ��һ����,��һ���°�ť
	private JButton button2 = null;
	private JButton button3 = null;
	// ѡ�������µ�������
	private JComboBox comboBox1 = null;
	private JComboBox comboBox2 = null;
	// ��������
	private Calendar calendar = null;
	// �����µ�ѡ�񼯺϶���
	private String[] years = null;
	private String[] months = null;
	// ��ǰ��,��,��
	private int year1, month1, day1;
	private JPanel panel = null;
	private String tits[] = { "��", "һ", "��", "��", "��", "��", "��" };
	private String title = "ѡ������";
	private Point location = null;
	private MouseDoubleClickedEvent mdcEvent = null;
	private JCalendarChooser chooser = null;
	// ��ʶ�ֶ�
	private boolean flag;

}
