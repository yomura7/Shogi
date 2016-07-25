package koma;


public class Keima extends Koma {

	public Keima(boolean face, boolean direction) {
		super(face, direction);
		if (face == true && direction == true) {
			super.imgName = "./koma_img/sgs06.png";
		} else if (face == true && direction == false) {
			super.imgName = "./koma_img/sgs36.png";
		} else if (face == false && direction == true) {
			super.imgName = "./koma_img/sgs16.png";
		} else if (face == false && direction == false) {
			super.imgName = "./koma_img/sgs46.png";
		}
	}

}
