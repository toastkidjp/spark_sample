/**
 * (130307) 作成
 * @see <a href="http://ajax.studynet.jp/articles/studyjavascript/study-javascript2">Ajax入門|Ajaxの基礎と応用の学習</a> より
 */
function calc() {
    var weight  = document.getElementById("weight");
    var radio = document.getElementsByName('measure');
    var measure;
	for(var i = 0; i < radio.length; i++) {
		if(radio[i].checked) {
			measure = radio[i].value;
		}
	}
    var str_val2 = weight.value;
    var kcal;
    if (isNaN(str_val2) || str_val2 == "" ) {
        textMessage = "数値を入力してください。";
    } else {
        weight = parseFloat(str_val2);
        if (measure == "light"){
        	kcal = weight * 30;
        } else if (measure == "middle"){
        	kcal = weight * 35;
        } else {
        	kcal = weight * 40;
        }
        textMessage =  "<H3>計算結果</H3>"
        textMessage += "理想体重 = " + weight + "kg<br />";
        textMessage += "推奨カロリー = " + kcal + "kcal<br />";
    }
    message.innerHTML = "<p>" + textMessage + "</p>";
}
