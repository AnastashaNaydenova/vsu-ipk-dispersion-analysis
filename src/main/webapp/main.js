async function saveForm(event) {
	event.preventDefault();
	let organization = {};
	if(this['id']) {
		organization.id = parseInt(this['id'].value);
	}
	organization.name = this['name'].value;
	organization.individual = this['individual'].checked;
	organization.area = parseFloat(this['area'].value);
	await fetch('/vida/organization', {
		method: 'POST',
		headers: {
			"Content-Type": "application/json",
		},
		body: JSON.stringify(organization),
	});
	await loadList();
}

async function loadEditForm() {
	let organization;
	if(this.organizationId) {
		let response = await fetch('/vida/organization?id=' + this.organizationId);
		organization = await response.json();
	} else {
		organization = {name: '', individual: false, area: ''};
	}
	let div = document.getElementById('container');
	let form = document.createElement('form');
	if(this.organizationId) {
		let inputId = document.createElement('input');
		inputId.type = 'hidden';
		inputId.name = 'id';
		inputId.value = this.organizationId;
		form.appendChild(inputId);
	}
	let divName = document.createElement('div');
	divName.className = 'control';
	let labelName = document.createElement('label');
	labelName.setAttribute('for', 'name');
	labelName.appendChild(document.createTextNode('Название:'))
	divName.appendChild(labelName);
	let inputName = document.createElement('input');
	inputName.type = 'text';
	inputName.id = 'name';
	inputName.name = 'name';
	inputName.value = organization.name;
	divName.appendChild(inputName);
	form.appendChild(divName);
	let divIndividual = document.createElement('div');
	divIndividual.className = 'control';
	let labelIndividual = document.createElement('label');
	let inputIndividual = document.createElement('input');
	inputIndividual.type = 'checkbox';
	inputIndividual.name = 'individual';
	inputIndividual.value = 'individual';
	inputIndividual.checked = organization.individual;
	labelIndividual.appendChild(inputIndividual);
	labelIndividual.appendChild(document.createTextNode(' Является ли частным предпринимателем'));
	divIndividual.appendChild(labelIndividual);
	form.appendChild(divIndividual);
	let divArea = document.createElement('div');
	divArea.className = 'control';
	let labelArea = document.createElement('label');
	labelArea.setAttribute('for', 'area');
	labelArea.appendChild(document.createTextNode('Площадь (Га):'));
	divArea.appendChild(labelArea);
	let inputArea = document.createElement('input');
	inputArea.type = 'text';
	inputArea.id = 'area';
	inputArea.name = 'area';
	inputArea.value = organization.area;
	divArea.appendChild(inputArea);
	form.appendChild(divArea);
	let buttonSend = document.createElement('button');
	buttonSend.type = 'submit';
	buttonSend.appendChild(document.createTextNode('Сохранить'));
	form.appendChild(buttonSend);
	form.addEventListener('submit', saveForm);
	div.innerHTML = '';
	div.appendChild(form);
}

async function loadList() {
	let response = await fetch('/vida/organization');
	let organizations = await response.json();
	let div = document.getElementById('container');
	div.innerHTML = '';
	let table = document.createElement('table');
	let tr;
	tr = document.createElement('tr');
	let th;
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
		let td;
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

window.addEventListener("load", loadList);
