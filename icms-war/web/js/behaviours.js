dojo.require("dijit._base.scroll");
//dojo.require("dijit.Dialog");
//dojo.require("dijit.Tooltip");

dojo.addOnLoad(function(){
    if(dojo.byId("translate")){
        dojo.connect(dojo.byId("translate"), "onsubmit", function(e){
            e.preventDefault();
            ajaxTranslate();
        });
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