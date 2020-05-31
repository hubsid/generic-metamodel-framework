function showHideChildren(elem) {
    console.log(elem);
    if(elem.innerText == '-') {
        elem.parentElement.parentElement.children[1].hidden = true;
        elem.innerText = '+';
    }
    else if(elem.innerText == '+') {
        elem.parentElement.parentElement.children[1].hidden = false;
        elem.innerText = '-';
    }
}