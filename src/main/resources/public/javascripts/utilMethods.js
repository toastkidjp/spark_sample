/**
 * �֗����\�b�h�����^
 */

/** 
 * ���l��3���J���}��؂�̕�����ɂ��ĕԂ��B
 * <HR>
 * (130511) �ǉ�<BR>
 * @see <a href="http://webdev.seesaa.net/article/22769178.html">JavaScript��3����؂�̃J���}</a>
 */
function addFigure(str) {
	var num = new String(str).replace(/,/g, "");
	while(num != (num = num.replace(/^(-?\d+)(\d{3})/, "$1,$2")));
	return num;
}
