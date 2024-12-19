# TextModifier Library

The **TextModifier** library provides a simple and efficient way to modify immutable text for markup in Android applications using Kotlin. 

## Features

- Modify immutable text with ease.
- Apply styles like bold, italic, underline, and strikethrough.
- Change text color and background color.
- Adjust font size.
- Combine multiple styles seamlessly.

## Installation

To use the **TextModifier** library in your project, add the following dependency to your `build.gradle` file:

```gradle
implementation "com.pinu.textlibrary:textmodifier:1.0.0"
```

## Usage

### Initialization

To use the `TextModifier` class, access its singleton instance:

```kotlin
val textModifier = TextModifier.instance
```

### Methods

#### 1. Apply Bold Text

```kotlin
val boldText = textModifier.makeBold("This is bold text")
```

#### 2. Apply Italic Text

```kotlin
val italicText = textModifier.makeItalic("This is italic text")
```

#### 3. Apply Underline

```kotlin
val underlinedText = textModifier.underlineText("This is underlined text")
```

#### 4. Apply Strikethrough

```kotlin
val strikethroughText = textModifier.strikeThroughText("This is strikethrough text")
```

#### 5. Change Text Color

```kotlin
val coloredText = textModifier.changeTextColor(context, "This is colored text", R.color.my_color)
```

#### 6. Change Font Size

```kotlin
val resizedText = textModifier.changeTextSize("This is resized text", 20f)
```

#### 7. Combine Multiple Styles

```kotlin
val styledText = textModifier.applyMultipleStyles(
    context,
    text = "Styled Text",
    isBold = true,
    isItalic = true,
    isUnderline = true,
    colorResId = R.color.my_color,
    sizeInSp = 18f
)
```

## Example

Here’s a complete example:

```kotlin
val textModifier = TextModifier.instance

val styledText = textModifier.applyMultipleStyles(
    context,
    text = "Example Styled Text",
    isBold = true,
    isItalic = true,
    isUnderline = true,
    isStrikeThrough = true,
    colorResId = R.color.teal_200,
    sizeInSp = 24f
)

textView.text = styledText
```
