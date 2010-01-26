var user_pic_div = document.getElementById("user_pic");
var user_sex_div = document.getElementById("user_sex");
var user = {
    "id": null,
    "first_name": null,
    "last_name": null,
    "pic_with_logo": null,
    "sex": null,
    "relationship_status": null
};
var user_infos = null;
var markup = "";
var api = null;

$(document).ready(function () {
    FB.ensureInit(function () {
        FB.Facebook.get_sessionState().waitUntilReady(function() {
            api = FB.Facebook.apiClient;
            // detect if the user is currently logged in,
            var session = api.get_session();

            if (!session) {
                $("#user_infos").html('<fb:login-button v="2" size="xlarge" onlogin="window.location.reload(true);">Se connecter</fb:login-button>');
            } else {
                user.id = session.uid;
            }
            var sequencer = new FB.BatchSequencer();
            pendingUserInfos = api.users_getInfo([user.id], ["first_name", "last_name", "pic_with_logo", "sex", "relationship_status"], sequencer);

            sequencer.execute(function() {
                user.first_name = pendingUserInfos.result[0].first_name;
                user.last_name = pendingUserInfos.result[0].last_name;
                user.pic_with_logo = pendingUserInfos.result[0].pic_with_logo;
                user.sex = pendingUserInfos.result[0].sex;
                user.relationship_status = pendingUserInfos.result[0].relationship_status;
                $("#user_infos").html("Hey "+user.first_name+"!<br /><img src=\""+user.pic_with_logo+"\" />");

                showArticlesByPreferedSex();
                showAds();
            });            
        });
    });
});

function showArticlesByPreferedSex() {
    $("span.prefered_sex").each(function(i, el){
        if(el.innerText == user.sex || el.innerText == "none") {
            $(el).parent().show();
        }
    });
}

function showAds() {
    var selected_ads = [];
    $("div.advertisement").each(function(i, el){
        if(serv(el) == "facebook") {
            if((crit(el) == "sex" && val(el) == user.sex.toLowerCase())
                || (crit(el) == "relationship_status" && val(el) == user.relationship_status.toLowerCase())) {
                selected_ads.push($(el));
            }
        } else if(serv(el) == "meteo") {
            if(crit(el) == "conditions" && commonElements(val(el),$("#conditions").text())) {
                selected_ads.push($(el));
            } else if (crit(el) == "temperature") {
                if(val(el).substr(0, 1) == ">" && parseInt($("#temperature").text()) > val(el).substring(1, val(el).length)) {
                    selected_ads.push($(el));
                }
                else if(val(el).substr(0, 1) == ">=" && parseInt($("#temperature").text()) >= val(el).substring(1, val(el).length)) {
                    selected_ads.push($(el));
                }
                else if(val(el).substr(0, 1) == "<" && parseInt($("#temperature").text()) < val(el).substring(1, val(el).length)) {
                    selected_ads.push($(el));
                }
                else if(val(el).substr(0, 1) == "<=" && parseInt($("#temperature").text()) <= val(el).substring(1, val(el).length)) {
                    selected_ads.push($(el));
                }
                else if(parseInt(val(el)) == parseInt($("#temperature").text())) {
                    selected_ads.push($(el));
                }
            }
        }
    });

    var j = Math.round(Math.random()*selected_ads.length)-1;
    if(j < 0) j = 0;
    if(selected_ads.length > 0) {
        //        console.info("affichage de la pub : " + j);
        selected_ads[j].show();
    }
}

function serv(el) {
    return $(el).children(".advertisement_info.service").text().toLowerCase();
}

function crit(el) {
    return $(el).children(".advertisement_info.criteria").text().toLowerCase();
}

function val(el) {
    return $(el).children(".advertisement_info.criteriaValue").text().toLowerCase();
}

function commonElements(text1, text2) {
    var arr1 = text1.toLowerCase().split(" ");
    var arr2 = text2.toLowerCase().split(" ");
    var yes = false;

    for (i in arr1) {
        if(arr2.lastIndexOf(arr1[i]) != -1) yes = true;
    }
    return yes;
}

//dojo.require("dijit._base.scroll");
//dojo.require("dijit.Dialog");
//dojo.require("dijit.Tooltip");
//
//dojo.addOnLoad(function(){
//    if(dojo.byId("translate")){
//        dojo.connect(dojo.byId("translate"), "onsubmit", function(e){

//            e.preventDefault();
//            ajaxTranslate();
//        });
//    }
//
//    if(dojo.byId("flickr")){
//        connectItems("flickr");
//    }
//});
//
//function ajaxTranslate(){
//    var contentNode = dojo.byId("translation");
//    var spinnerNode = dojo.byId("translate_spinner");
//
//    dojo.style(spinnerNode, "display", "block");
//    dojo.fadeIn({
//        node: spinnerNode
//    }).play();
//    dojo.xhrGet({
//        url: dojo.byId("translate").action+"?"+dojo.formToQuery(dojo.byId('translate')),
//        handleAs: "text",
//        load: function(data, args){
//            dojo.fadeOut({
//                node: spinnerNode,
//                onEnd: function(){
//                    contentNode.innerHTML = data;
//                    dojo.style(spinnerNode, "display", "none");
//                    dijit.scrollIntoView(contentNode);
//                }
//            }
//            ).play();
//        },
//        error: function(error, args){
//            console.warn("error! " + error.toString() + " " + args.toString());
//            dojo.fadeOut({
//                node: spinnerNode,
//                onEnd: function(){
//                    dojo.style(spinnerNode, "display", "none");
//                }
//            }).play();
//        }
//    });
//}
//
//function connectItems(service){
//    // connect actions with every links
//    dojo.query("td."+service+"_item").forEach(function(node){
//        new dijit.Tooltip({
//            connectId: [dojo.byId("thumb_"+node.id)],
//            label: dojo.byId("description_"+node.id).innerHTML
//        });
//    });
//}