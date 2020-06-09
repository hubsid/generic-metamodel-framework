window.addEventListener("load", function onpageload() {
	elemRef.attrTools = document.getElementById("right-panel-tools");
	elemRef.attrReload = document.getElementById("attrs-reload-button");
	elemRef.attrInheritedButton = document.getElementById("attrs-inherited-button");
	elemRef.attrList = document.getElementById("attr-list").tBodies.item(0);
	selectThisOt(document.querySelector(".ot-description[ot-id='0']"));
});

function makeUrl_ot_children(id) {
	return "/ot/" + id + "/children";
}

function makeUrl_ot_attrs(id) {
	return "/ot/" + id + "/attributes";
}

function showHideChildren(elem) {
    // console.log(elem);
    var childOtContainer = elem.parentElement.parentElement.children[1];

    if(elem.innerText == '-') {
        childOtContainer.hidden = true;
        elem.innerText = '+';
    }
    else if(elem.innerText == '+') {
        childOtContainer.hidden = false;
        elem.innerText = '-';
        if(childOtContainer.childElementCount == 0)
        	fetchChildren(childOtContainer);
    }
}

function refreshChildren(refreshButton) {
	if(refreshButton.previousElementSibling.innerText == '-')
		fetchChildren(refreshButton.parentElement.parentElement.children[1]);
}

function fetchChildren(childOtContainer) {
	console.log("fetching children.");
	var id = 1 * childOtContainer.previousElementSibling.getAttribute("ot-id");
	console.log("id = " + id);
	var callback = function(responseHTML) { childOtContainer.innerHTML = responseHTML;};
	ajaxCall(makeUrl_ot_children(id), callback);
}

function ajaxCall(url, callback) {
	console.log("making ajaxCall to " + url);
	var req = new XMLHttpRequest();
	req.onreadystatechange = function() {
		console.log("readystate change, readystate=" + this.readyState + ", status=" + this.status);
		if(this.readyState == 4) {
			if(this.status == 200) {
				console.log("success:");
				// console.log(this.responseText);
				callback(this.responseText);
			}
			else {
				console.log(this.responseText);
			}
		}
	};
	req.open("GET", url);
	req.send();
	console.log("sent request.");
}

selection = {
	attr: undefined,
	ot: undefined,
	getOtId: function() {return 1 * this.ot.getAttribute("ot-id");},
	showInheritedAttrs: false
}

cache = {
	attrs: {}
}

elemRef = {
	attrList: undefined,
	attrTools: undefined,
	attrReload: undefined,
	attrInheritedButton: undefined
}

function selectThisOt(elem) {
	if(selection.ot) {
		if(selection.ot == elem)
			return;
		selection.ot.classList.remove('selected');
	}
	elem.classList.add("selected");
	selection.ot = elem;
	fetchAttrs();
}

function fetchAttrs() {
	var otId = selection.getOtId();
	console.log("latest changes");
	var attrList = elemRef.attrList;

	if(cache.attrs[otId] == undefined) {
		console.log("attr cache empty, fetching");
		ajaxCall(makeUrl_ot_attrs(otId), function(response) {
			 attrList.innerHTML = response;
			 cache.attrs[otId] = getChildNodesArray(attrList);
		});
	}
	else {
		console.log("fetching from cache");
		removeChildNodes(attrList);
		setChildNodesFromNodeArray(attrList, cache.attrs[otId]);
	}
}

function forceFetchAttrs() {
	var otId = selection.getOtId();
	var attrList = elemRef.attrList;

	ajaxCall(makeUrl_ot_attrs(otId), function(response) {
		 attrList.innerHTML = response;
		 cache.attrs[otId] = response;
	});
}

function getChildNodesArray(elem) {
	var array = [];
	for(childNode of elem.childNodes)
		array.push(childNode);
	return array;
}

function removeChildNodes(elem) {
	while(elem.hasChildNodes())
		elem.removeChild(elem.firstChild);
}

function setChildNodesFromNodeArray(elem, nodeArr) {
	for(node of nodeArr)
		elem.appendChild(node);
}

function showInheritedAttrs() {
	if(selection.showInheritedAttrs = false) {
		//show it

	}
	else {
		//hide it
	}
}