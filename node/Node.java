package node;

import load.Load;
import constraint.Constraint;

import java.util.TreeSet;

public class Node {

	protected double x;
	protected double y;

	protected double u;
	protected double v;

	protected TreeSet<Dof> dofs;
	protected TreeSet<Load> loads;
	protected TreeSet<Constraint> constraints; 

	public Node(double x, double y) {
		this.x = x;
		this.y = y;
		
		this.dofs = new TreeSet<Dof>();
		this.loads = new TreeSet<Load>();
		this.constraints = new TreeSet<Constraint>();
		
		this.dofs.add(Dof.X);
		this.dofs.add(Dof.Y);
	}

	public boolean addLoad(Load l) {
		boolean rc = this.dofs.contains(l.getDof());
		if (rc) {
			if (this.loads.contains(l)) {
				for (Load load:this.loads) {
					if (load == l) {
						load.setValue(load.getValue() + l.getValue());
					}
				}
			} else {
				this.loads.add(l);
			}
		}
		return rc;
	}

	public boolean addConstraint(Constraint c) {
		return this.dofs.contains(c.getDof()) ? this.constraints.add(c) : false;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getU() {
		return this.u;
	}

	public boolean setU(double u) {
		boolean rc = !this.constraints.contains(Constraint.X);
		if (rc) {
			this.u = u;
		}
		return rc;
	}
	
	public double getV() {
		return this.v;
	}

	public boolean setV(double v) {
		boolean rc = !this.constraints.contains(Constraint.Y);
		if (rc) {
			this.v = v;
		}
		return rc;
	}

	public TreeSet<Load> getLoads() {
		return this.loads;
	}

	public TreeSet<Constraint> getConstraints() {
		return this.constraints;
	}

	public TreeSet<Dof> getDofs() {
		return this.dofs;
	}

	public int getDofNum() {
		return this.dofs.size();
	}
}
