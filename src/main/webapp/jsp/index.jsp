<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>简单·爱</title>
	<link rel="stylesheet"  href="css/jquery.mobile-1.3.2.min.css">
	<link rel="stylesheet" href="css/jqm-demos.css">
	<link rel="shortcut icon" href="css/images/battery.ico">
	<script src="js/jquery.js"></script>
	<script src="js/index.js"></script>
	<script src="js/jquery.mobile-1.3.2.min.js"></script>
</head>
<body>

<div data-role="page" class="jqm-demos jqm-demos-home">

	<div data-role="header" class="jqm-header">
		<h1 class="jqm-logo"><img src="css/images/spring_logo.jpg" alt="The continue..."></h1>
		<a href="#" class="jqm-search-link ui-btn-right" data-icon="search" data-iconpos="notext">Search</a>
<div class="jqm-search">
<ul class="jqm-list">
<li data-section="Widgets" data-filtertext="accordions collapsible sets content formatting grouped inset mini"><a href="widgets/accordions/">Accordion</a></li>

<li data-section="Widgets" data-filtertext="ajax navigation navigate event method"><a href="widgets/navigation/" data-ajax="false">AJAX Navigation</a></li>

<li data-section="Widgets" data-filtertext="autocomplete filter reveal listviews remote listviewbeforefilter placeholder"><a href="widgets/autocomplete/" data-ajax="false">Autocomplete</a></li>

<li data-section="Widgets" data-filtertext="buttons inputs forms inline theme grouped icons mini disabled"><a href="widgets/buttons/" data-ajax="false">Buttons</a></li>

<li data-section="Widgets" data-filtertext="checkboxes checkboxradio inputs forms mini disabled"><a href="widgets/checkbox/">Checkboxes</a></li>

<li data-section="Widgets" data-filtertext="collapsibles content formatting"><a href="widgets/collapsibles/" data-ajax="false">Collapsibles</a></li>

<li data-section="Widgets" data-filtertext="controlgroups selects checkboxradio buttons horizontal vertical"><a href="widgets/controlgroups/">Controlgroup</a></li>

<li data-section="Widgets" data-filtertext="dialogs modal popups"><a href="widgets/dialog/">Dialogs</a></li>

<li data-section="Widgets" data-filtertext="fixed toolbars headers footers sections fullscreen"><a href="widgets/fixed-toolbars/">Fixed toolbars</a></li>

<li data-section="Widgets" data-filtertext="flip toggle switch binary slider selects forms disabled"><a href="widgets/sliders/switch.html" data-ajax="false">Flip switch toggle</a></li>

<li data-section="Widgets" data-filtertext="footer toolbars footers sections"><a href="widgets/footers/">Footer toolbar</a></li>

<li data-section="Widgets" data-filtertext="forms inputs slider button range toggle switch label disabled accessible fieldcontains elements"><a href="widgets/forms/">Form elements</a></li>

<li data-section="Widgets" data-filtertext="grids columns blocks content formatting rwd responsive"><a href="widgets/grids/">Grids</a></li>

<li data-section="Widgets" data-filtertext="header toolbars fixed fullscreen sections"><a href="widgets/headers/">Header toolbar</a></li>

<li data-section="Widgets" data-filtertext="icons buttons disc position"><a href="widgets/icons/">Icons</a></li>

<li data-section="Widgets" data-filtertext="links navigation ajax prefetch cache"><a href="widgets/links/">Links</a></li>

<li data-section="Widgets" data-filtertext="listviews thumbnails icons nested split button collapsible ul ol"><a href="widgets/listviews/" data-ajax="false">Listviews</a></li>

<li data-section="Widgets" data-filtertext="ajax loader overlay spinner pages"><a href="widgets/loader/" data-ajax="false">Loader overlay</a></li>

<li data-section="Widgets" data-filtertext="navbars navmenu toolbars links icons footer header"><a href="widgets/navbar/" data-ajax="false">Navbar</a></li>

<li data-section="Widgets" data-filtertext="navbars persistent header footer links navmenu"><a href="widgets/fixed-toolbars/footer-persist-a.html">Navbar, persistent</a></li>

<li data-section="Widgets" data-filtertext="pages single multipage templates ajax nav"><a href="widgets/pages/">Pages</a></li>

<li data-section="Widgets" data-filtertext="panels sliding nav modal transition display reveal overlay push rwd responsive"><a href="widgets/panels/">Panels <span class="ui-li-count">New</span></a></li>

<li data-section="Widgets" data-filtertext="popup dialog modal transition tooltip lightbox form overlay screen flip pop fade transition"><a href="widgets/popup/">Popup</a></li>

<li data-section="Widgets" data-filtertext="radiobuttons checkboxradio inputs forms disabled grouped"><a href="widgets/radiobuttons/">Radio buttons</a></li>

<li data-section="Widgets" data-filtertext="selectmenus custom native multiple optgroup disabled forms"><a href="widgets/selects/">Select</a></li>

<li data-section="Widgets" data-filtertext="slider, single sliders range inputs forms disabled"><a href="widgets/sliders/" data-ajax="false">Slider, single</a></li>

<li data-section="Widgets" data-filtertext="slider, dual range sliders rangesliders inputs forms disabled"><a href="widgets/sliders/rangeslider.html" data-ajax="false">Slider, dual range <span class="ui-li-count">New</span></a></li>

<li data-section="Widgets" data-filtertext="tables column th td toggle responsive tables rwd hide show tabular"><a href="widgets/table-column-toggle/">Table, column toggle <span class="ui-li-count">New</span></a></li>

<li data-section="Widgets" data-filtertext="tables reflow th td responsive rwd columns tabular"><a href="widgets/table-reflow/">Table, reflow <span class="ui-li-count">New</span></a></li>

<li data-section="Widgets" data-filtertext="text inputs textarea numeric email tel file date time month clear pattern placeholder forms"><a href="widgets/textinputs/">Text inputs & textarea</a></li>

<li data-section="Widgets" data-filtertext="page transitions animated pages ajax navigation flip slide fade pop" data-ajax="false"><a href="widgets/transitions/" data-ajax="false">Transitions</a></li>

<li data-role="list-divider">Collapsibles</li>

<li data-section="Demo Showcase" data-filtertext="dynamic collapsible set accordion append expand"><a href="examples/collapsibles/dynamic-collapsible.html" data-ajax="false">Dynamic collapsible</a></li>

<li data-role="list-divider">Controlgroups</li>

<li data-section="Demo Showcase" data-filtertext="dynamic controlgroup buttons selects checkboxes forms"><a href="examples/controlgroups/dynamic-controlgroup.html" data-ajax="false">Dynamic controlgroup</a></li>

<li data-role="list-divider">Listviews</li>

<li data-section="Demo Showcase" data-filtertext="grid listview responsive grids responsive listviews lists ul"><a href="examples/listviews/grid-listview.html" data-ajax="false">Grid Listview</a></li>

<li data-section="Demo Showcase" data-filtertext="autodividers anchor jump scroll linkbars listviews lists ul"><a href="examples/listviews/autodividers-linkbar.html" data-ajax="false">Autodividers Linkbar</a></li>

<li data-section="Demo Showcase" data-filtertext="listviews autodividers selector autodividersselector lists ul ol"><a href="examples/listviews/autodividers-selector.html" data-ajax="false">Autodividers Selector</a></li>

<li data-role="list-divider">Navigation</li>

<li data-section="Demo Showcase" data-filtertext="backbone and require.js example navigation router"><a href="examples/backbone-require/index.html" data-ajax="false">Backbone and Require.js example</a></li>

<li data-section="Demo Showcase" data-filtertext="server redirection with server-side support php"><a href="examples/redirect/" data-ajax="false">Redirection with server-side support</a></li>

<li data-role="list-divider">Panels</li>

<li data-section="Demo Showcase" data-filtertext="panel styling slide panels sliding panels shadow rwd responsive breakpoint"><a href="examples/panels/panel-styling.html" data-ajax="false">Panel styling</a></li>

<li data-section="Demo Showcase" data-filtertext="open panel on swipe panels left right"><a href="examples/panels/panel-swipe-open.html" data-ajax="false">Open panel on swipe</a></li>

<li data-role="list-divider">Popups</li>

<li data-section="Demo Showcase" data-filtertext="dynamic popups popup images lightbox"><a href="examples/popups/dynamic-popup.html" data-ajax="false">Dynamic popup</a></li>

<li data-section="Demo Showcase" data-filtertext="arrow popups popover"><a href="examples/popups/arrow.html" data-ajax="false">Popup with arrow</a></li>

<li data-role="list-divider">Responsive Tables</li>

<li data-section="Demo Showcase" data-filtertext="responsive tables reflow stack custom styles"><a href="examples/tables/movie-list.html" data-ajax="false">Reflow: Custom styles</a></li>

<li data-section="Demo Showcase" data-filtertext="responsive tables reflow heading groups rwd breakpoint"><a href="examples/tables/financial-grouped-reflow.html" data-ajax="false">Reflow: Heading groups</a></li>

<li data-section="Demo Showcase" data-filtertext="responsive tables reflow refresh method dynamically inject data"><a href="examples/tables/reflow-refresh.html" data-ajax="false">Reflow: Refresh method</a></li>

<li data-section="Demo Showcase" data-filtertext="responsive tables column toggle hide rwd breakpoint customization options"><a href="examples/tables/movie-list-toggle-options.html" data-ajax="false">Column toggle: Customization options</a></li>

<li data-section="Demo Showcase" data-filtertext="responsive tables column toggle heading groups rwd breakpoint"><a href="examples/tables/financial-grouped-columns.html" data-ajax="false">Column toggle: Heading groups</a></li>

<li data-section="Demo Showcase" data-filtertext="responsive tables column toggle refresh method dynamically inject data"><a href="examples/tables/columntoggle-refresh.html" data-ajax="false">Column toggle: Refresh method</a></li>

<li data-section="Demo Showcase" data-filtertext="responsive tables table column toggle phone comparison rwd breakpoint"><a href="examples/tables/phone-compare.html" data-ajax="false">Column toggle demo: Phone comparison</a></li>

<li data-role="list-divider">Sliders</li>

<li data-section="Demo Showcase" data-filtertext="slider tooltip handle value extension input range sliders forms"><a href="examples/slider/tooltip.html" data-ajax="false">Tooltip extension</a></li>

<li data-role="list-divider">Swipe</li>

<li data-section="Demo Showcase" data-filtertext="swipe to navigate page transitions navigation"><a href="examples/swipe/swipe-page.html" data-ajax="false">Swipe to navigate</a></li>

<li data-section="Demo Showcase" data-filtertext="swipe to delete list item listviews lists ul ol"><a href="examples/swipe/swipe-list.html" data-ajax="false">Swipe to delete list item</a></li>

<li data-role="list-divider">Forms</li>

<li data-section="Questions & Answers" data-filtertext="CSS styles apply widget scope wrap selector customize"><a href="faq/question-template.html">Why won't my CSS styles apply correctly to a widget?</a></li>

<li data-section="Questions & Answers" data-filtertext="form update value enhance pageinit refresh"><a href="faq/updating-the-value-of-enhanced-form-elements-does-not-work.html">Updating the value of enhanced form elements does not work.</a></li>

<li data-section="Questions & Answers" data-filtertext="HTML 5 inputs appearance keyboard picker calendar date time slider file color"><a href="faq/my-html-5-inputs-look-different-in-browsers.html">My HTML 5 inputs look different across devices and browsers.</a></li>

<li data-section="Questions & Answers" data-filtertext="range search inputs slider number text degrade"><a href="faq/my-range-search-input-type-is-being-changed.html">My range or search inputs are being change to number/text.</a></li>

<li data-section="Questions & Answers" data-filtertext="custom select popup dialog logic"><a href="faq/sometimes-custom-select-shows-as-dialog-popup.html">Sometimes my custom select shows as a popup other times its a dialog.</a></li>

<li data-section="Questions & Answers" data-filtertext="disable button issue class method"><a href="faq/disabling-a-button-does-not-work.html">Disabling a button does not work.</a></li>

<li data-section="Questions & Answers" data-filtertext="fixed toolbar header footer fullscreen select input bug issue"><a href="faq/controls-in-header-footer.html">Controls in my fixed header or footer are not responding or behave erratically.</a></li>

<li data-role="list-divider">Pages</li>

<li data-section="Questions & Answers" data-filtertext="head load scripts styles pageinit onload pagebeforecreate ajax nav pages"><a href="faq/scripts-and-styles-not-loading.html">Why aren't my scripts and styles loading?</a></li>

<li data-section="Questions & Answers" data-filtertext="document.ready onload paginit DOM ready on ready scripts "><a href="faq/dom-ready-not-working.html">Why isn't DOM ready working for my scripts?</a></li>

<li data-section="Questions & Answers" data-filtertext="ajax nav load page mobile.loadpage"><a href="faq/how-do-i-load-a-page.html">How do I load a page?</a></li>

<li data-section="Questions & Answers" data-filtertext="ajax nav multi page document load"><a href="faq/why-is-only-the-first-page-loaded.html">Why is only the first page of my multi page document loaded?</a></li>

<li data-section="Questions & Answers" data-filtertext="pass url query params ajax nav"><a href="faq/pass-query-params-to-page.html">I'm trying to pass query params to a page but it's not working?</a></li>

<li data-section="Questions & Answers" data-filtertext="hash pass parameters information ajax nav"><a href="faq/pass-via-the-hash-to-page.html">I'm trying to pass information via the hash but it's not working?</a></li>

<li data-section="Questions & Answers" data-filtertext="application cache status error isLocal ajax nav"><a href="faq/the-application-cache-is-not-working.html">I'm trying to use the application cache but it's not working.</a></li>

<li data-section="Questions & Answers" data-filtertext=">create refresh event trigger pageInit refresh method content injected page not enhanced."><a href="faq/injected-content-is-not-enhanced.html">Content injected into a page is not enhanced.</a></li>

<li data-section="Questions & Answers" data-filtertext=">create trigger event pageInit injected HTML"><a href="faq/triggering-create-on-injected-content-does-not-work.html">Triggering create on injected HTML does not work.</a></li>

<li data-section="Questions & Answers" data-filtertext="auto-enhance element stop preventnative role none"><a href="faq/how-can-i-stop-auto-enhancement-of-elements.html">How can I stop JQM from auto-enhancing an element?</a></li>

<li data-section="Questions & Answers" data-filtertext="auto-enhance block container parent stop preventnative role none"><a href="faq/how-can-i-stop-auto-enhancement-of-a-block-of-elements.html">How can I stop JQM from enhancing a block of elements?</a></li>

<li data-section="Questions & Answers" data-filtertext="page title ajax nav head"><a href="faq/how-do-i-control-page-titles.html">How do I control page titles?</a></li>

<li data-section="Questions & Answers" data-filtertext="ajax nav load page loadPage"><a href="faq/how-do-i-load-a-page.html">How do I load a page?</a></li>

<li data-role="list-divider">Events</li>

<li data-section="Questions & Answers" data-filtertext="touch mouse events vmouseover, vmousedown, vmousemove, vmouseup, vclick, vmousecancel"><a href="faq/how-do-i-use-touch-mouse-events.html">How do I use touch and mouse events?</a></li>

<li data-role="list-divider">Theme and styling</li>

<li data-section="Questions & Answers" data-filtertext="theme swatch css themeroller customize icons colors fonts style"><a href="faq/how-does-theming-work.html">How does theming work?</a></li>

<li data-role="list-divider">Apps</li>

<li data-section="Questions & Answers" data-filtertext="How do I need to configure PhoneGap Cordova?"><a href="faq/how-configure-phonegap-cordova.html">How do I need to configure PhoneGap/Cordova?</a></li>
    </ul>
    
</div>

	</div><!-- /header -->

	<div data-role="content" class="jqm-content">

		<div class="jqm-home-welcome">
		<h2>The End of The World</h2>
		
		<p class="jqm-intro">#后会无期#我曾经跨过山和大海，也穿过人山人海，我曾经拥有着一切，转眼都飘散如烟。假如今生最后一次触碰篮球，你是否会想起第一次与它的美丽邂逅。</p>

        <p class="jqm-intro"><small>Why does the sun go on shining</small></p>
		
		</div>
		

		<ul data-role="listview" data-inset="true" data-theme="d" data-icon="false" data-filter-placeholder="Search..." class="jqm-list jqm-home-list">
            <li><a href="intro/"><h2>Introduction</h2><p>New to jQuery Mobile? Start here.</p></a></li>
            <li><a href="examples/"><h2>Demo Showcase</h2><p>Examples of how to customize and extend jQuery Mobile.</p></a></li>
            <li><a href="faq/"><h2>Questions &amp; Answers</h2><p>Common issues and questions, explained.</p></a></li>
			<li data-section="Widgets" data-filtertext="responsive web design rwd adaptive PE accessible mobile breakpoints media query"><a href="intro/rwd.html"><h2>Going Responsive</h2><p>How to use RWD with jQuery Mobile</p></a></li>
		</ul>

		<h2 class="jqm-home-widget">Widget reference</h2>

<p class="jqm-intro">Test drive every component in the library, and easily build pages by copying and pasting the markup configuration you need.</p>

<ul data-role="listview" data-inset="true" data-filter="true" data-theme="d" data-divider-theme="d" data-icon="false" data-filter-placeholder="Search widgets..." data-global-nav="demos" class="jqm-list">
	<li data-section="Widgets" data-filtertext="accordions collapsible sets content formatting grouped inset mini"><a href="widgets/accordions/">Accordion</a></li>
	
	<li data-section="Widgets" data-filtertext="ajax navigation navigate event method"><a href="widgets/navigation/" data-ajax="false">AJAX Navigation</a></li>
	
	<li data-section="Widgets" data-filtertext="autocomplete filter reveal listviews remote listviewbeforefilter placeholder"><a href="widgets/autocomplete/" data-ajax="false">Autocomplete</a></li>
	
	<li data-section="Widgets" data-filtertext="dialogs modal popups"><a href="widgets/dialog/">Dialogs</a></li>
</ul>

	</div><!-- /content -->

	<div data-role="footer" class="jqm-footer">
		<p class="jqm-version"></p>
		<p>Copyright 2014 The Fantasy Foundation</p>
	</div><!-- /jqm-footer -->

</div>


</body>
</html>