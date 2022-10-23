class MobileNavbar {
	constructor(mobileMenu, navList, navLinks) {
		this.mobileMenu = document.querySelector(mobileMenu);
		this.navList = document.querySelector(navList);
		this.navLinks = document.querySelectorAll(navLinks);
		this.activeClass = "active";

		this.handleClick = this.handleClick.bind(this);
	}

	animateLinks() {
		this.navLinks.forEach((link, index) => {
			link.style.animation
				? (link.style.animation = "")
				: (link.style.animation = `navLinkFade 0.5s ease forwards ${index / 7 + 0.3
					}s`);
		});
	}

	handleClick() {
		this.navList.classList.toggle(this.activeClass);
		this.mobileMenu.classList.toggle(this.activeClass);
		this.animateLinks();
	}

	addClickEvent() {
		this.mobileMenu.addEventListener("click", this.handleClick);
	}

	init() {
		if (this.mobileMenu) {
			this.addClickEvent();
		}
		return this;
	}
}

const mobileNavbar = new MobileNavbar(
	".mobile-menu",
	".nav-list",
	".nav-list li",
);
mobileNavbar.init();




let count = 1;
document.getElementById("radio1").checked = true;

setInterval(function() {
	nextImage();
}, 2000)

function nextImage() {
	count++;
	if (count > 3) {
		count = 1;
	}

	document.getElementById("radio1" + count).checked = true;

}



let sidebar = document.querySelector(".sidebar");
let closeBtn = document.querySelector("#btn");
let searchBtn = document.querySelector(".bx-search");

closeBtn.addEventListener("click", () => {
	sidebar.classList.toggle("open");
	menuBtnChange();//calling the function(optional)
});

searchBtn.addEventListener("click", () => { // Sidebar open when you click on the search iocn
	sidebar.classList.toggle("open");
	menuBtnChange(); //calling the function(optional)
});

// following are the code to change sidebar button(optional)
function menuBtnChange() {
	if (sidebar.classList.contains("open")) {
		closeBtn.classList.replace("bx-menu", "bx-menu-alt-right");//replacing the iocns class
	} else {
		closeBtn.classList.replace("bx-menu-alt-right", "bx-menu");//replacing the iocns class
	}
}