var currentTab = 0; // Current tab is set to be the first tab (0)
showTab(currentTab); // Display the current tab

function showTab(n) {
    // This function will display the specified tab of the form...
    var page = document.getElementsByClassName("page");
    page[n].style.display = "block";
    document.getElementById("add-form").classList.remove("zoomOut");

    setTimeout(function () {
        document.getElementById("add-form").classList.add("zoomOut");
    }, 10)
    if (n == 0) {
        document.getElementById("prevBtn").style.display = "none";
    } else {
        document.getElementById("prevBtn").style.display = "inline";
    }
    if (n == (page.length - 1)) {
        document.getElementById("nextBtn").innerHTML = "Submit";
    } else {
        document.getElementById("nextBtn").innerHTML = "Next";
    }
    //... and run a function that will display the correct step indicator:
}

function nextPrev(n) {
    // This function will figure out which tab to display
    var page = document.getElementsByClassName("page");
    // Exit the function if any field in the current tab is invalid:
    page[currentTab].style.display = "none";
    // Increase or decrease the current tab by 1:
    currentTab = currentTab + n;
    // // if you have reached the end of the form...
    if (currentTab >= page.length) {
        // ... the form gets submitted:
        document.getElementById("add-form").submit();
        return false;
    }
    // Otherwise, display the correct tab:
    showTab(currentTab);
}