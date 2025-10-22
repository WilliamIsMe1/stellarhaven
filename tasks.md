BIG tasks:
 [ ] Document virtually everything so if I stop I can keep going
 
 [ ] Create Game Design Document
 
 [ ] Finish model package
 
 [ ] 

{
  "$schema": "https://json-schema.org/draft-07/schema",
  "type": "object",
  "properties": {
    "type": {
      "type": "string",
      "description": "The type of model being used",
      "enum": [
        "static",
        "block"
      ]
    },
    "foreground": {
      "type": "string",
      "description": "Path to foreground file"
    },
    "background": {
      "type": "string",
      "description": "path to background file"
    },
    "objects": {
      "type": "array",
      "description": "the foreground objects",
      "items": {
        "type": "object",
        "properties": {
          "texture": {
            "type": "string",
            "description": "texture of the object"
          },
          "x": {
            "type": "number"
          },
          "y": {
            "type": "number"
          }
        },
        "required": [
          "texture",
          "x",
          "y"
        ]
      }
    },
    "texture": {
      "type": "string",
      "description": "The texture of a static object"
    }
  },
  "required": [
    "type"
  ],
  "if": {
    "properties": {
      "type": {
        "const": "static"
      }
    }
  },
  "then": {
    "required": [
      "texture"
    ]
  },
  "else": {
    "required": [
      "foreground",
      "background",
      "objects"
    ]
  }
}
