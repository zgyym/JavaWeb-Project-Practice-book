
function editCart(cartItemId , buyCount){
    window.location.href="cart.do?operate=editCart&cartItemId="+cartItemId+"&buyCount="+buyCount;
}

/*
var xmlHttpRequest ;

function createXMLHttpRequest(){
    if(window.XMLHttpRequest){
        //符合DOM2标准的浏览器 ，xmlHttpRequest的创建方式
        xmlHttpRequest = new XMLHttpRequest() ;
    }else if(window.ActiveXObject){//IE浏览器
        try{
            xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
        }catch (e) {
            xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
        }
    }
}

function editCart(cartItemId , buyCount){
    createXMLHttpRequest();
    var url = "cart.do?operate=editCart&cartItemId="+cartItemId+"&buyCount="+buyCount;
    xmlHttpRequest.open("GET",url,true);
    //设置回调函数
    xmlHttpRequest.onreadystatechange = editCartCB ;
    //发送请求
    xmlHttpRequest.send();
}*/
