db.createCollection("student");
db.createCollection("teacher");
db.createCollection("course");

//recordatorio: agregar alumnos al curso que diga en el examen

//creamos los examenes
exam1 = {
id_course: 1,
partial1: 4,
partial2: 1,
partial3: 5,
final: 3
}
exam2 = {
id_course: 2,
partial1: 4,
partial2: 3,
partial3: 3,
final: 3
}
exam3 = {
id_course: 3,
partial1: 4,
partial2: 6,
partial3: 7,
final: 5
}
exam4 = {
id_course: 1,
partial1: 8,
partial2: 6,
partial3: 7,
final: 7
}
exam5 = {
id_course: 2,    
partial1: 9,
partial2: 8,
partial3: 7,
final: 8
}
exam6 = {
id_course: 3,    
partial1: 4,
partial2: 2,
partial3: 1,
final: 2
}

//creando estudiantes
studentVar = [{
number: 1,
name: "facu",
surname: "sanchez",
birthday: 01/02/1998,
exam: [exam1, exam3, exam5]
},{
number: 2,
name: "gaston",
surname: "sanchez",
birthday: 01/02/1998,
exam: [exam3, exam4, exam2]
},{
number: 3,
name: "ramiro",
surname: "sanchez",
birthday: 01/02/1998,
exam: [exam1, exam2, exam3]
},{
number: 4,
name: "diego",
surname: "sanchez",
birthday: 01/02/1998,
exam: [exam6, exam4, exam5]
},{
number: 5,
name: "agustin",
surname: "sanchez",
birthday: 01/02/1998,
exam: [exam4, exam2, exam6]
},{
number: 6,
name: "luciano",
surname: "sanchez",
birthday: 01/02/1998,
exam: [exam2, exam1, exam3]
},{
number: 7,
name: "fabricio",
surname: "sanchez",
birthday: 01/02/1998,
exam: [exam4, exam6, exam2]
},{
number: 8,
name: "fernando",
surname: "sanchez",
birthday: 01/02/1998,
exam: [exam1, exam3, exam5]
},{
number: 9,
name: "leo",
surname: "sanchez",
birthday: 01/02/1998,
exam: [exam1, exam2, exam6]
},{
number: 10,
name: "martin",
surname: "sanchez",
birthday: 01/02/199,
exam: [exam5, exam3, exam1]
}];

//agregamos a los estudiantes a la coleccion de estudiantes
db.student.insert(studentVar);

//creamos los profesores
teacherVar = [{
number: 1,
name: "gaston",
surname: "ramirez",
birthday: 01/02/1998
},{
number: 2,
name: "gaston",
surname: "fernandez",
birthday: 01/02/1998
},{
number: 3,
name: "gaston",
surname: "aguirre",
birthday: 01/02/1998
}];

//agregamos la estructura de profesores a la coleccion de profesores
db.teacher.insert(teacherVar)

//creamos la estructura de los cursos
courseVar = [{
id_course: 1,
name: "lengua",
student: studentVar
},{
id_course: 2,
name: "matematicas",
student: studentVar
},{
id_course: 3,
name: "Historia",
student: studentVar
}]

//agregamos la coleccion de cursos a los cursos
db.course.insert(courseVar)

//agregamos profesores a cursos
db.course.update( { id_course: 2 }, {$addToSet: {teacher: db.teacher.findOne( {number:1} ) } } );
db.course.update( { id_course: 1 }, {$addToSet: {teacher: db.teacher.findOne( {number:3} ) } } );
db.course.update( { id_course: 3 }, {$addToSet: {teacher: db.teacher.findOne( {number:2} ) } } );


//buscamos profesor 
db.course.find({"teacher.number": 3}).sort({name:1}); //buscamos profesor por id
db.course.find({"teacher.name": "gaston", "teacher.surname": "ramirez"}).sort({name:1}); //buscamos profesor por nombre

//buscamos alumno por curso y nota
db.student.find({"exam": { $elemMatch: {"final": {$gt:4}, "id_course": 3} } } ); //buscamos por curso y nota final


    

