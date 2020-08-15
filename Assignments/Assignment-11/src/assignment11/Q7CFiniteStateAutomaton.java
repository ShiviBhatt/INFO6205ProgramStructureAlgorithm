package assignment11;

public class Q7CFiniteStateAutomaton {
	int fsm_state;
	char fsm_input;

	public boolean is_final_state(int state) {
		return (state == 1 || state == 2) ? true : false;
	}

	public int get_start_state() {
		return 0;
	}

	public int fsm_move(int state, char fsm_input) {
		if (fsm_input != 'X' && fsm_input != 'Y' && fsm_input != 'Z') {
			return 0;
		}
		switch (state) {
		case 0:
			if (fsm_input == 'X') {
				return 1;
			} else if (fsm_input == 'Z') {
				return 2;
			}
			break;
		case 1:
			if (fsm_input == 'X' || fsm_input == 'Y') {
				return 1;
			}

			break;
		default:
			return 0;
		}

		return 0;
	}

	public boolean recognize(String str) {
		if (str == "") {
			return false;
		}

		int index = 0;
		int state = get_start_state();
		char current;
		while (index < str.length() && state != 1) {
			current = str.charAt(index++);
			state = fsm_move(state, current);
		}

		if (is_final_state(state)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {

		String str = null;
		Q7CFiniteStateAutomaton fsa = new Q7CFiniteStateAutomaton();
		str = "X(X|Y)*|Z";

		if (fsa.recognize(str)) {
			System.out.println("The string is recognized.");
		} else {
			System.out.println("The string is rejected.");
		}
	}
}
