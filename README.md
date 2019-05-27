# Spook
Spook is an object-oriented shader language, that can be compiled to GLSL.


### Compiler arguments

The spook compiler **requires the path to a .spook file as its first argument.**

The rest of the arguments are optional and are described here:

|Name|Arguments|Description|
|----|---------|-----------|
|Pretty Print | `-pp` `-prettyprint`               | Prints out the AST that was generated from the Spook code.|
|Print        | `-p` `-print` `-sout`              | Prints out the compiled target code.|
|Clipboard    | `-c` `-copy` `-clipboard` `-pasta` | Copies the compiled target code to the clipboard, for quick pasting.|
|Output file  | `-o` `-output`                     | Specifies an output file, to save the compiled target code to.|