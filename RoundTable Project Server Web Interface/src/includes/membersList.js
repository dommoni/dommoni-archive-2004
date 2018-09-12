function move(fbox, tbox, rightBoxName) 
{
	var arrFbox = new Array();
	var arrTbox = new Array();
	var arrLookup = new Array();
	var i;
	for (i = 0; i < tbox.options.length; i++) 
	{
		arrLookup[tbox.options[i].text] = tbox.options[i].value;<!-- id or name of the given option in the select box -->
		arrTbox[i] = tbox.options[i].text;<!-- text of field (what is being shown) -->
	}
	
	var fLength = 0;
	var tLength = arrTbox.length;
	for(i = 0; i < fbox.options.length; i++) 
	{
		arrLookup[fbox.options[i].text] = fbox.options[i].value;
		if (fbox.options[i].selected && fbox.options[i].value != "") 
		{
			arrTbox[tLength] = fbox.options[i].text;
			tLength++;
		}
		else 
		{
			arrFbox[fLength] = fbox.options[i].text;
			fLength++;
   	}	
	}
	
	arrFbox.sort();
	arrTbox.sort();
	fbox.length = 0;  <!-- reset the fbox and the tbox -->
	tbox.length = 0;  <!-- reset the fbox and the tbox -->
	var c;
	var no;
	for(c = 0; c < arrFbox.length; c++) 
	{
		no = new Option(); <!-- create a new option to insert into fBox -->
		no.value = arrLookup[arrFbox[c]]; <!-- this returns the id -->
		no.text = arrFbox[c];				<!-- this sets the value -->
		fbox[c] = no;
	}
	for(c = 0; c < arrTbox.length; c++) 
	{
		no = new Option();
		no.value = arrLookup[arrTbox[c]];
		no.text = arrTbox[c];
		tbox[c] = no;
  	}
	
	//update the return array
	returnArray.length = 0;  <!-- reset the array -->
	var rightBox;
	
	if(rightBoxName == "tbox") 
	{
		rightBox=tbox;
	}
	else 
	{
		rightBox = fbox;
	}
	
	for (i = 0; i < rightBox.length; i++) 
	{
		var position = arrLookup[rightBox.options[i].text];
		returnArray[returnArray.length] = allKeys[position];
	}
}

function moveAll(fbox, tbox) 
{
	for (x = 0; x < fbox.options.length; x++)
	{
		var newOption = new Option();
		newOption.value = fbox.options[x].value;
		newOption.text = fbox.options[x].text;
		tbox.add(newOption);
	}
	fbox.length = 0;
	tbox.options = tbox.options.sort();
}

