[Back to home](readme.md)
#Developer documentation

## Assumptions of the results.
When you call a certain entity you get always the simple properties of the entity you asked for (in a EntityAsSubject), plus a summary of the container and list of entities (EntityAsListitem) it belongs to.
When you call a list of entities (filtered or not) you will receive a list of summarizes (EntityAsListitem) of the entities in the list.

## Specification of the endpoints

### Loanings

### Members
@GetMapping("member/{id}")
    public @ResponseBody
    ResponseEntity<MemberAsSubject> getMemberById(@PathVariable Long id) {
        return service.findMemberById(id).map(value -> new ResponseEntity<>(new MemberAsSubject(value), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("member")
    public @ResponseBody
    ResponseEntity<List<MemberAsListitem>> getAllMembers() {
        List<MemberAsListitem> memberSimpleList = service.findAllMembers().stream().map(MemberAsListitem::new).collect(Collectors.toList());
        return new ResponseEntity<>(memberSimpleList, HttpStatus.OK);
    }

    @PostMapping("member")
    @ResponseStatus(HttpStatus.CREATED)
    public Member addMember(@RequestBody @Valid Member member) {
        return service.addMember(member);
    }

### Stuf