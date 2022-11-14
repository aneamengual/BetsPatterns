package gui;

import javax.swing.table.AbstractTableModel;
import domain.Usuario;

public class UserAdapter extends AbstractTableModel{
	private Usuario user;
	public UserAdapter(Usuario user) {
		this.user=user;
	}
	
	public int getRowCount() {
		return user.getCuentaDeApuestas();
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int columnIndex) {
		String name;
		if(columnIndex==0) {
			name= "Event";
		}else if(columnIndex==1) {
			name= "Question";
		}else if(columnIndex==2) {
			name= "Event Date";
		}else {
			name= "Bet($)";
		}
		
		return name;
		
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object sol;
		if(columnIndex==0) {
			sol= user.getApuestas().get(rowIndex).getEvento().getDescription();
		}else if(columnIndex==1) {
			sol= user.getApuestas().get(rowIndex).getRespuesta().getQuestion().getQuestion();
		}else if(columnIndex==2) {
			sol= user.getApuestas().get(rowIndex).getEvento().getEventDate();
		}else {
			sol= user.getApuestas().get(rowIndex).getApuesta();
		}
		return sol;
	}
}