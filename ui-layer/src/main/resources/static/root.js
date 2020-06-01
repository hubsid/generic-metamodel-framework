function makeUrl_ot_children(id) {
	return "/ot/" + id + "/children";
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
        refreshChildOTs(childOtContainer);
    }
}

function refreshChildOTs(childOtContainer) {
	console.log("refreshing.");
	var id = 1 * childOtContainer.parentElement.getAttribute("ot-id");
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
				console.log(this.responseText);
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
