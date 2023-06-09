package tanks.game.myinput;

import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class MyInput extends JComponent {

	private boolean[] masButtons;

	public MyInput() {

		masButtons = new boolean[256];

		for (int i = 0; i < masButtons.length; i++) {

			final int KEY_BUTTON = i;

			getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
					.put(KeyStroke.getKeyStroke((char) i, 0, false), i * 2);
			getActionMap().put((i * 2), new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					masButtons[KEY_BUTTON] = true;
				}
			});

			getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
					.put(KeyStroke.getKeyStroke((char) i, 0, true), i * 2 + 1);
			getActionMap().put((i * 2 + 1), new AbstractAction() {

				@Override
				public void actionPerformed(ActionEvent e) {
					masButtons[KEY_BUTTON] = false;
				}
			});

		}
	}

	public boolean[] getMasButtons() {
		return Arrays.copyOf(masButtons, masButtons.length);
	}

	public boolean checkButton(int keyButton) {
		return masButtons[keyButton];
	}

}
