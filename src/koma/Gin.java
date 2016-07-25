package koma;


public class Gin extends Koma {

	public Gin(boolean face, boolean direction) {
		super(face, direction);
		if (face == true && direction == true) {
			super.imgName = "./koma_img/sgs05.png";
		} else if (face == true && direction == false) {
			super.imgName = "./koma_img/sgs35.png";
		} else if (face == false && direction == true) {
			super.imgName = "./koma_img/sgs15.png";
		} else if (face == false && direction == false) {
			super.imgName = "./koma_img/sgs45.png";
		}
	}
}
