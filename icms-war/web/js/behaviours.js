var user_pic_div = document.getElementById("user_pic");
var user_sex_div = document.getElementById("user_sex");
var user = {
    "id": null,
    "sex": null,
    "relationship_status": null
};
var user_infos = null;
var markup = "";
var api = null;

$(document).ready(function () {
    //    $("div.post").each(function(i, el){
    //        $(el).hide();
    //    });

    FB.ensureInit(function () {
        FB.Facebook.get_sessionState().waitUntilReady(function() {
            api = FB.Facebook.apiClient;
            // detect if the user is currently logged in,
            var session = api.get_session();

            if (!session) {
                markup +=
                '<fb:login-button v="2" size="xlarge" onlogin="window.location.reload(true);">Se connecter</fb:login-button>';
            } else {
                user.id = session.uid;
                markup += '<fb:profile-pic size="square" uid="'+user.id+'" facebook-logo="true"></fb:profile-pic>';
                markup += '<br />Bienvenue <fb:name uid="'+user.id+'" useyou="false" linked="true"></fb:name> !!';
            }
            var sequencer = new FB.BatchSequencer();
            pendingUserInfos = api.users_getInfo([user.id], ["first_name", "last_name", "sex", "relationship_status"], sequencer);

            sequencer.execute(function() {
                user.sex = pendingUserInfos.result[0].sex;
                user.relationship_status = pendingUserInfos.result[0].relationship_status;
                $("#user_infos").html(markup + "<br />You're a " + user.relationship_status + " " + user.sex + ".");

                sortArticlesByPreferedSex();
            });            
        });
    });
});

function sortArticlesBtPreferedSex() {
    $("span.prefered_sex").each(function(i, el){
        if(el.innerText == user.sex || el.innerText == "none") {
            $(el).parent().show();
        }
    });
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