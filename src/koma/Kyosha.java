package koma;


public class Kyosha extends Koma {

	public Kyosha(boolean face, boolean direction) {
		super(face, direction);
		if (face == true && direction == true) {
			super.imgName = "./koma_img/sgs07.png";
		} else if (face == true && direction == false) {
			super.imgName = "./koma_img/sgs37.png";
		} else if (face == false && direction == true) {
			super.imgName = "./koma_img/sgs17.png";
		} else if (face == false && direction == false) {
			super.imgName = "./koma_img/sgs47.png";
		}
	}



}
