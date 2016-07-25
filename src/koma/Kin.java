package koma;


public class Kin extends Koma {

	public Kin(boolean face, boolean direction) {
		super(face, direction);

		// 金は裏面なし
		if (face == false) {
			face = true;
		}
		if (face == true && direction == true) {
			super.imgName = "./koma_img/sgs04.png";
		} else if (face == true && direction == false) {
			super.imgName = "./koma_img/sgs34.png";
		}
	}



}
