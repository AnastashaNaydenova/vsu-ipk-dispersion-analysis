async function loadEditForm() {
	let organization = null;
	if(this.organizationId) {
		let response = await fetch('/vida/organization?id=' + this.organizationId);
		organization = await response.json();
	} else {
		organization = {name: '', individual: false, area: ''};
	}
	let html = '<form>';
	html += '<div class="control">';
	html += '<label>Название</label>';
	html += `<input type="text" name="name" value="${organization.name}">`;
	html += '</div>';
	html += '<div class="control">';
	html += `<label><input type="checkbox" name="individual" value="individual" ${organization.individual ? 'checked' : ''}> Является ли частным</label>`;
	html += '</div>';
	html += '<div class="control">';
	html += '<label>Площадь (Га)</label>';
	html += `<input type="text" name="area" value="${organization.area}">`;
	html += '</div>';
	html += '</form>';
	let div = document.getElementById('container');
	div.innerHTML = html;
}

async function loadList() {
	let response = await fetch('/vida/organization');
	let organizations = await response.json();
	let div = document.getElementById('container');
	div.innerHTML = '';
	let table = document.createElement('table');
	let tr = null;
	tr = document.createElement('tr');
	let th = null;
	th = document.createElement('th');
	th.appendChild(document.createTextNode('Название'));
	tr.appendChild(th);
	th = document.createElement('th');
	th.appendChild(document.createTextNode('Является ли частным'));
	tr.appendChild(th);
	th = document.createElement('th');
	th.appendChild(document.createTextNode('Площадь (Га)'));
	tr.appendChild(th);
	tr.appendChild(document.createElement('th'));
	table.appendChild(tr);
	organizations.forEach(function(organization) {
		tr = document.createElement('tr');
		let td = null;
		td = document.createElement('td');
		td.appendChild(document.createTextNode(organization.name));
		tr.appendChild(td);
		td = document.createElement('td');
		td.appendChild(document.createTextNode(organization.individual ? 'да' : 'нет'));
		tr.appendChild(td);
		td = document.createElement('td');
		td.appendChild(document.createTextNode(organization.area));
		tr.appendChild(td);
		td = document.createElement('td');
		let button = document.createElement('button');
		button.organizationId = organization.id;
		button.addEventListener('click', loadEditForm);
		button.appendChild(document.createTextNode('Редактировать'));
		td.appendChild(button);
		tr.appendChild(td);
		table.appendChild(tr);
	});
	div.appendChild(table);
	let button = document.createElement('button');
	button.appendChild(document.createTextNode('Добавить'));
	button.addEventListener('click', loadEditForm);
	div.appendChild(button);
}

window.addEventListener("load", function() {
	let a = document.getElementById('open-button');
	a.addEventListener("click", loadList);
});
