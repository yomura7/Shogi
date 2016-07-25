package koma;



public class Fu extends Koma {

	// TODO 使う予定のString配列
	private String[] name ={
		"./koma_img/sgs08.png",
		"./koma_img/sgs38.png",
		"./koma_img/sgs18.png",
		"./koma_img/sgs48.png"
	};

	// TODO コンストラクタで条件分岐させず、nameだけをsuperに渡す
	public Fu(boolean face, boolean direction) {
		super(face, direction);
		if (face == true && direction == true) {
			super.imgName = "./koma_img/sgs08.png";
		} else if (face == true && direction == false) {
			super.imgName = "./koma_img/sgs38.png";
		} else if (face == false && direction == true) {
			super.imgName = "./koma_img/sgs18.png";
		} else if (face == false && direction == false) {
			super.imgName = "./koma_img/sgs48.png";
		}
	}


}
