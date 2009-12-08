dojo.require("dijit._base.scroll");
dojo.require("dijit.Dialog");
dojo.require("dijit.Tooltip");

dojo.addOnLoad(function(){
    if(dojo.byId("translate")){
        dojo.connect(dojo.byId("translate"), "onsubmit", function(e){
            e.preventDefault();
            ajaxTranslate();
        });
    }

    if(dojo.byId("flickr")){
        connectItems("flickr");
    }
});

function ajaxTranslate(){
    var contentNode = dojo.byId("translation");
    var spinnerNode = dojo.byId("translate_spinner");

    dojo.style(spinnerNode, "display", "block");
    dojo.fadeIn({
        node: spinnerNode
    }).play();
    dojo.xhrGet({
        url: dojo.byId("translate").action+"?"+dojo.formToQuery(dojo.byId('translate')),
        handleAs: "text",
        load: function(data, args){
            dojo.fadeOut({
                node: spinnerNode,
                onEnd: function(){
                    contentNode.innerHTML = data;
                    dojo.style(spinnerNode, "display", "none");
                    dijit.scrollIntoView(contentNode);
                }
            }
            ).play();
        },
        error: function(error, args){
            console.warn("error! " + error.toString() + " " + args.toString());
            dojo.fadeOut({
                node: spinnerNode,
                onEnd: function(){
                    dojo.style(spinnerNode, "display", "none");
                }
            }).play();
        }
    });
}

function connectItems(service){
    // connect actions with every links
    dojo.query("td."+service+"_item").forEach(function(node){
        new dijit.Tooltip({
            connectId: [dojo.byId("thumb_"+node.id)],
            label: dojo.byId("description_"+node.id).innerHTML
        });

//        dojo.connect(dojo.byId("thumb_"+node.id), "onclick", function(e){
//            e.preventDefault();
//            dojo.query(".masterpiece").map(function(node){
//                if(!dojo.hasClass(node, "hidden")) dojo.addClass(node, "hidden");
//            });
//
//            dojo.query("."+service+"_thumb").map(function(node){
//                if(dojo.hasClass(node, "hidden")) dojo.removeClass(node, "hidden");
//            });
//
//            dojo.removeClass("masterpiece_"+node.id, "hidden");
//            dojo.addClass("thumb_"+node.id, "hidden");
//            console.info(dojo.hasClass("masterpiece_"+node.id, "hidden"));
//        });
    });
}