# hibernate-mysql-manyToManyMapping
A Simple Hibernate MySQL example explaining ManyToMany relationship

@ManyToMany – May value associations with multi tables scenarios

Entity 1

@ManyToMany(cascade = { CascadeType.ALL })

@JoinTable(name = "EMPLOYEE_MEETING", joinColumns = { @JoinColumn(name = "EMPLOYEE_ID") }, inverseJoinColumns = { @JoinColumn(name = "MEETING_ID") }) 

private Set<Meeting> meetings = new HashSet<Meeting>(); 

Entity 2
 
@ManyToMany(mappedBy = "meetings") 

private Set<Employee> employees = new HashSet<Employee>();
