package koma;


public class Kaku extends Koma {

	public Kaku(boolean face, boolean direction) {
		super(face, direction);
		if (face == true && direction == true) {
			super.imgName = "./koma_img/sgs03.png";
		} else if (face == true && direction == false) {
			super.imgName = "./koma_img/sgs33.png";
		} else if (face == false && direction == true) {
			super.imgName = "./koma_img/sgs13.png";
		} else if (face == false && direction == false) {
			super.imgName = "./koma_img/sgs43.png";
		}
	}


}
