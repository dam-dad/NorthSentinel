package dad.northsentinel.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Torreta {

	private double timeShoot = 0;

	private double lifeTime = 0;

	private int numberDirections;

	private IntegerProperty cost = new SimpleIntegerProperty();

	private IntegerProperty numberShots = new SimpleIntegerProperty();

	private IntegerProperty maxNumberShots = new SimpleIntegerProperty();
	private IntegerProperty damage = new SimpleIntegerProperty();
	private DoubleProperty fireRate = new SimpleDoubleProperty();
	
}
