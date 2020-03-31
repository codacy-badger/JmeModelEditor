import com.jme3.math.Vector3f
import com.jme3.material.RenderState.BlendMode
import com.simsilica.lemur.Button
import com.simsilica.lemur.Button.ButtonAction
import com.simsilica.lemur.Command
import com.simsilica.lemur.Insets3f
import com.simsilica.lemur.component.DynamicInsetsComponent
import com.simsilica.lemur.HAlignment
import com.simsilica.lemur.VAlignment
import com.simsilica.lemur.component.QuadBackgroundComponent

//
// Colors
//
def textColor = color(0.894, 0.894, 0.894, 1)
def textHighlightColor = color(0.894, 0.894, 0.894, 1)
def textFocusColor = color(0.894, 0.894, 0.894, 1)
def textShadowColor = color(0, 0, 0, 0.75f)
def textShadowHighlightColor = color(0, 0, 0, 0.75f)
def textShadowFocusColor = color(0, 0, 0, 0.75f)

def buttonColor = color(0.345, 0.345, 0.345, 1)
def buttonPressedColor = color(0.416, 0.416, 0.416, 1)
def buttonHighlightColor = color(0.416, 0.416, 0.416, 1)

def buttonPrimaryColor = color(0.298, 0.498, 0.78, 1)
def buttonPrimaryPressedColor = color(0.443, 0.62, 0.863, 1)
def buttonPrimaryHighlightColor = color(0.443, 0.62, 0.863, 1)

def listColor = color(0.2, 0.2, 0.2, 1)
def listSelectionColor = color(0.282, 0.463, 0.718, 0.5)

def textFieldColor = color(0.114, 0.114, 0.114, 1)

def toolBarColor = color(0.137, 0.137, 0.137, 1)

def buttonToolBarPressedColor = color(0.282, 0.463, 0.718, 1)
def buttonToolBarHighlightColor = color(0.282, 0.463, 0.718, 1)
def buttonToolBarColor = color(0, 0, 0, 0)

def windowColor = color(0.294, 0.294, 0.294, 1)
def windowTitleColor = color(0.2, 0.2, 0.2, 1)
//
// Global styling
//
selector("editor-style") {
    fontSize = 14
    color = textColor
    highlightColor = textHighlightColor
    focusColor = textFocusColor
    shadowColor = textShadowColor
    highlightShadowColor = textShadowHighlightColor
    focusShadowColor = textShadowFocusColor
    shadowOffset = new Vector3f(1, -1, -1);
}

//
// Button
//
def buttonPressedCmd = new Command<Button>() {
    @Override
    void execute(Button source) {
        if (source.pressed) {
            source.background = new QuadBackgroundComponent(buttonPressedColor)
        } else {
            if (source.highlightOn) {
                source.background = new QuadBackgroundComponent(buttonHighlightColor)
            } else {
                source.background = new QuadBackgroundComponent(buttonColor)
            }
        }
    }
}
def buttonHoverCmd = new Command<Button>() {
    @Override
    void execute(Button source) {
        if (source.highlightOn) {
            source.background = new QuadBackgroundComponent(buttonHighlightColor)
        } else {
            source.background = new QuadBackgroundComponent(buttonColor)
        }
    }
}
def buttonCmds = [
        (ButtonAction.Down)        : [buttonPressedCmd],
        (ButtonAction.Up)          : [buttonPressedCmd],
        (ButtonAction.HighlightOn) : [buttonHoverCmd],
        (ButtonAction.HighlightOff): [buttonHoverCmd]
]

selector("button", "editor-style") {
    background = new QuadBackgroundComponent(buttonColor)
    buttonCommands = buttonCmds
    textHAlignment = HAlignment.Center
    textVAlignment = VAlignment.Center
}

//
// primary button
//
def primaryButtonPressedCmd = new Command<Button>() {
    @Override
    void execute(Button source) {
        if (source.pressed) {
            source.background = new QuadBackgroundComponent(buttonPrimaryPressedColor)
        } else {
            if (source.highlightOn) {
                source.background = new QuadBackgroundComponent(buttonPrimaryHighlightColor)
            } else {
                source.background = new QuadBackgroundComponent(buttonPrimaryColor)
            }
        }
    }
}
def primaryButtonHoverCmd = new Command<Button>() {
    @Override
    void execute(Button source) {
        if (source.highlightOn) {
            source.background = new QuadBackgroundComponent(buttonPrimaryHighlightColor)
        } else {
            source.background = new QuadBackgroundComponent(buttonPrimaryColor)
        }
    }
}
def primaryButtonCmds = [
        (ButtonAction.Down)        : [primaryButtonPressedCmd],
        (ButtonAction.Up)          : [primaryButtonPressedCmd],
        (ButtonAction.HighlightOn) : [primaryButtonHoverCmd],
        (ButtonAction.HighlightOff): [primaryButtonHoverCmd]
]
selector("primary-button", "editor-style") {
    background = new QuadBackgroundComponent(buttonPrimaryColor)
    buttonCommands = primaryButtonCmds
    textHAlignment = HAlignment.Center
    textVAlignment = VAlignment.Center
}

//
// Listbox
//
selector("list.selector", "editor-style") {
    background = new QuadBackgroundComponent(listSelectionColor)
    background.material.material.additionalRenderState.blendMode = BlendMode.AlphaAdditive;
}

//
// TextField
//
selector("textField", "editor-style") {
    background = new QuadBackgroundComponent(textFieldColor)
}

//
// Toolbar
//
selector("toolbar", "editor-style") {
    background = new QuadBackgroundComponent(toolBarColor)
}

def toolbarPressedCmd = new Command<Button>() {
    @Override
    void execute(Button source) {
        if (source.pressed) {
            source.background = new QuadBackgroundComponent(buttonToolBarPressedColor)
        } else {
            if (source.highlightOn) {
                source.background = new QuadBackgroundComponent(buttonToolBarHighlightColor)
            } else {
                source.background = new QuadBackgroundComponent(buttonToolBarColor)
            }
        }
    }
}
def toolbarHoverCmd = new Command<Button>() {
    @Override
    void execute(Button source) {
        if (source.highlightOn) {
            source.background = new QuadBackgroundComponent(buttonToolBarHighlightColor)
        } else {
            source.background = new QuadBackgroundComponent(buttonToolBarColor)
        }
    }
}
def toolbarCmds = [
        (ButtonAction.Down)        : [toolbarPressedCmd],
        (ButtonAction.Up)          : [toolbarPressedCmd],
        (ButtonAction.HighlightOn) : [toolbarHoverCmd],
        (ButtonAction.HighlightOff): [toolbarHoverCmd]
]

selector("toolbar", "button", "editor-style") {
    insets = new Insets3f(4, 4, 4, 0)
    background = new QuadBackgroundComponent(buttonToolBarColor)
    buttonCommands = toolbarCmds
}

//
// Window
//
selector("window", "editor-style") {
    background = new QuadBackgroundComponent(windowColor)
}

selector("window", "title-wrapper", "editor-style") {
    background = new QuadBackgroundComponent(windowTitleColor)
}

selector("window", "title", "editor-style") {
    insets = new Insets3f(2, 0, 2, 0)
    textHAlignment = HAlignment.Center
    textVAlignment = VAlignment.Center
}

selector("window", "button-wrapper", "editor-style") {
    insetsComponent = new DynamicInsetsComponent(0.5, 1, 0.5, 0)
}

//
// Open file
//
selector("open-file", "button", "editor-style") {
    insets = new Insets3f(8, 8, 8, 0)
}

selector("open-file", "primary-button", "editor-style") {
    insets = new Insets3f(8, 8, 8, 8)
}

selector("open-file", "textField", "editor-style") {
    insets = new Insets3f(8, 8, 8, 8)
}

selector("open-file", "list.container", "editor-style") {
    insets = new Insets3f(0, 8, 0, 8)
    background = new QuadBackgroundComponent(listColor)
}

selector("open-file.list", "label", "editor-style") {
    insets = new Insets3f(4, 4, 4, 4)
}