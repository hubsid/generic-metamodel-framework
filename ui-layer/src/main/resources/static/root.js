window.addEventListener("load", function onpageload() {
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
	ot: undefined
}

cache = {
	attrs: {}
}

function selectThisOt(elem) {
	if(selection.ot) {
		selection.ot.classList.remove('selected');
	}
	elem.classList.add("selected");
	selection.ot = elem;
	fetchAttrs();
}

function fetchAttrs() {
	var otId = 1 * selection.ot.getAttribute("ot-id");
	var attrList = document.getElementById('attr-list').tBodies.item(0);

	if(cache.attrs[otId] == undefined) {
		console.log("attr cache empty, fetching");
		ajaxCall(makeUrl_ot_attrs(otId), function(response) {
			 attrList.innerHTML = response;
			 cache.attrs[otId] = response;
		});
	}
	else {
		console.log("fetching from cache");
		attrList.innerHTML = cache.attrs[otId];
	}
}

function forceFetchAttrs() {
	var otId = 1 * selection.ot.getAttribute("ot-id");
	var attrList = document.getElementById('attr-list').tBodies.item(0);

	ajaxCall(makeUrl_ot_attrs(otId), function(response) {
		 attrList.innerHTML = response;
		 cache.attrs[otId] = response;
	});
}
