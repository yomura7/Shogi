package koma;



public class Gyoku extends Koma {

	public Gyoku(boolean face, boolean direction) {
		super(face, direction);

		// 玉は裏面なし
		if (face == false) {
			face = true;
		}
		if (face == true && direction == true) {
			super.imgName = "./koma_img/sgs01.png";
		} else if (face == true && direction == false) {
			super.imgName = "./koma_img/sgs31.png";
		}
	}



}
