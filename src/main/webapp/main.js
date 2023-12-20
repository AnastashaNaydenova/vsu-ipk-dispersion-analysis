window.addEventListener("load", function() {
	let a = document.getElementById('open-button');
	a.addEventListener("click", async function () {
		let response = await fetch('http://localhost/vida/organization');
		let organizations = await response.json();
		let html = '<table style="border-collapse: collapse">';
		html += '<tr>';
		html += '<th style="border: 1px solid green;">Название</th>';
		html += '<th style="border: 1px solid green;">Является ли частным</th>';
		html += '<th style="border: 1px solid green;">Площадь (Га)</th>';
		html += '</tr>';
		organizations.forEach(function(organization) {
			html += '<tr>';
			html += `<td style="border: 1px solid green;">${organization.name}</td>`;
			html += `<td style="border: 1px solid green;">${organization.individual ? 'да' : 'нет'}</td>`;
			html += `<td style="border: 1px solid green;">${organization.area}</td>`;
			html += '</tr>';
		});
		html += '</table>';
		let div = document.getElementById('container');
		div.innerHTML = html;
	});
});
