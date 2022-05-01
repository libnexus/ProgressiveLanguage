;-
    printf(string, format) -> nothing
    print(*string) -> nothing
    input(string) -> string
    ask(string, type) -> object

    int(object) -> int
    float(object) -> float
    string(object) -> string
    list(object) -> list
    tuple(object) -> tuple
    hashmap(object) -> hashmap
    slice() -> slice
    slicing(object, object, object) -> slicing of up to 1 object, up to 2 slices

    eval(string) -> object

    type(object) -> type
    sleep(int) -> nothing
    time(function) -> (float, object)
    order(list | hashmap) -> ; ordered object
    quit() -> nothing ; finish execution
    map(function, object | objects) -> object ; apply function to an object or tuple of objects

-;

func main(args) {
    print(args)
}