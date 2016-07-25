package koma;



public class Hisha extends Koma {

	public Hisha(boolean face, boolean direction) {
		super(face, direction);
		if (face == true && direction == true) {
			super.imgName = "./koma_img/sgs02.png";
		} else if (face == true && direction == false) {
			super.imgName = "./koma_img/sgs32.png";
		} else if (face == false && direction == true) {
			super.imgName = "./koma_img/sgs12.png";
		} else if (face == false && direction == false) {
			super.imgName = "./koma_img/sgs42.png";
		}
	}




}
