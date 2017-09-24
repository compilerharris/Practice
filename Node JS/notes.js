console.log("Starting notes...")

var addNote = (title,body) => {
	console.log("Adding Note",title,"\nBody: "+body)
}
var getAll = () => {
	console.log("Getting All Notes")
}
var getNote = (title) => {
	console.log("Getting Note",title)
}
var removeNote = (title) => {
	console.log("Removed Note",title)
}

module.exports = {
	addNote,
	getAll,
	getNote,
	removeNote
};