package solitario;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class EstadoJuego extends JPanel {

	private JLabel puntos;
	private JLabel repartos;
	private JLabel cartas;

	/**
	 * Create the panel.
	 */
	public EstadoJuego() {
		
		JLabel lblPuntos = new JLabel("Puntos:");
		
		JLabel lblCartas = new JLabel("Cartas:");
		
		JLabel lblRepartos = new JLabel("Repartos:");
		
		cartas = new JLabel();
		
		repartos = new JLabel();
		
		puntos = new JLabel();
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPuntos)
						.addComponent(puntos, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(142)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCartas, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(cartas, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRepartos, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(repartos, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPuntos)
						.addComponent(lblCartas)
						.addComponent(lblRepartos))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cartas)
						.addComponent(puntos)
						.addComponent(repartos))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	public void setPuntos(int numPuntos) {
		puntos.setText(""+numPuntos);
	}
	public void setCartas(int numCartas){
		cartas.setText(""+ numCartas);
	}
	public void setRepartos(int numRepartos){
		repartos.setText(""+numRepartos);
	}
	

}
