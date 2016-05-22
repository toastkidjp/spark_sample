/**
 * (120722) 微妙にコード修正
 * @see <a href="http://ajax.studynet.jp/articles/studyjavascript/study-javascript2">Ajax入門|Ajaxの基礎と応用の学習</a> より
 */
function calcBMI() {
    var text1   = document.getElementById("height");
    var text2   = document.getElementById("weight");
    var message = document.getElementById("message");

    var str_val1 = text1.value;
    var str_val2 = text2.value;
    var bmi;
    var height;
    var weight;
    var standard;

    if (isNaN(str_val1) || str_val1 == "" || isNaN(str_val2) || str_val2 == "") {
        textMessage = "数値を入力してください。";
    } else {
        height = parseFloat(str_val1)/100;
        weight = parseFloat(str_val2);
        bmi = weight / (height * height);
        bmi = Math.round(bmi * 10);
        bmi = bmi / 10;
        standard = height * height * 22;
        standard = Math.round(standard * 10);
        standard = standard / 10;
        textMessage =  "<H3>計算結果</H3>"
        textMessage += "BMI値 = " + bmi + "<br />";
        textMessage += "標準体重 = " + standard + "<br />";
        if (bmi < 18.5){
            textMessage += "やせ過ぎです。<br />";
        } else if (18.5 <= bmi && bmi < 25){
            textMessage += "標準です。<br />";
        } else if (25   <= bmi && bmi < 30){
            textMessage += "肥満です。<br />";
        } else if (30   <= bmi ){
            textMessage += "高度肥満です。<br />";
        } else {
            
        }
    }
    message.innerHTML = "<p>" + textMessage + "</p>";
}
