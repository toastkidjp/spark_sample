/**
 * JavaScript で時計を表示する。
 * <HR>
 * (130325) ほぼコピペで作成<BR>
 * http://www.tohoho-web.com/how2/tec2.htm
 * <form name="formClock">
 * 	<input type="text" name="clock" size=25>
 * </form>
 * <script type="text/javascript" src="public/javascripts/clock.js">
 * </script>
 * 
 */
function clock() {
  d     = new Date();
  year  = 1900 + d.getYear(); 
  month = reformNumber(d.getMonth() + 1);
  date  = reformNumber(d.getDate());
  hour  = reformNumber(d.getHours());
  min   = reformNumber(d.getMinutes());
  sec   = reformNumber(d.getSeconds());
  document.formClock.clock.value =
     " " + year + "/" + month + "/" + date +
     " "+ hour + ":" + min + ":" + sec;
  setTimeout("clock()", 1000);
}
/**
 * 1桁の数字に0をつけて返す。
 * 
 */
function reformNumber(num){
	if (num < 10) {
		num = "0" + num;
	}
	return num;
}
clock();
