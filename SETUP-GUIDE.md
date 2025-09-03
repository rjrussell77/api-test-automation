# Gherkin and Cucumber Setup Guide

## ✅ What's Already Installed

Great news! You already have most of the essential extensions:
- ✅ Java Extension Pack (includes Java, Maven, debugging)
- ✅ REST Client (for testing APIs)
- ✅ Thunder Client (lightweight REST client)
- ✅ Maven support

## 🔧 Manual Installation Steps

### Step 1: Install Cucumber (Gherkin) Extension

1. **Open VS Code** (if not already open):
   ```bash
   code .
   ```

2. **Open Extensions Panel**:
   - Press `Cmd+Shift+X` (Mac) or `Ctrl+Shift+X` (Windows/Linux)
   - Or click the Extensions icon in the left sidebar

3. **Search for "Cucumber"**:
   - Type "Cucumber" in the search box
   - Look for "Cucumber (Gherkin)" by Alex Krechik
   - Click "Install"

4. **Alternative search terms**:
   - Try "Gherkin"
   - Try "BDD"
   - Look for extensions with ".feature" file support

### Step 2: Verify Installation

1. **Open a feature file**:
   - Navigate to `src/test/resources/features/api-endpoints.feature`
   - You should see syntax highlighting for Gherkin keywords

2. **Check for Cucumber commands**:
   - Press `Cmd+Shift+P` (Mac) or `Ctrl+Shift+P` (Windows/Linux)
   - Type "Cucumber" to see available commands

### Step 3: Test Gherkin Support

1. **Create a test feature file**:
   ```gherkin
   Feature: Test Gherkin Support
   
     Scenario: Verify syntax highlighting
       Given I have a feature file
       When I open it in VS Code
       Then I should see Gherkin syntax highlighting
   ```

2. **Check for these features**:
   - Syntax highlighting for `Feature:`, `Scenario:`, `Given`, `When`, `Then`
   - Auto-completion when typing Gherkin keywords
   - Step definition navigation (Ctrl+Click on steps)

## 🎯 Expected Results

After successful installation, you should see:

### In Feature Files:
- **Green highlighting** for `Feature:` and `Scenario:`
- **Blue highlighting** for `Given`, `When`, `Then`, `And`, `But`
- **Purple highlighting** for step parameters like `{string}` and `{int}`
- **Automatic indentation** and formatting

### Available Commands:
- `Cucumber: Go to Step Definition`
- `Cucumber: Go to Feature File`
- `Cucumber: Generate Step Definitions`
- `Cucumber: Run All Tests`

## 🚀 Quick Test

1. **Open your project**:
   ```bash
   code .
   ```

2. **Navigate to features**:
   - Open `src/test/resources/features/api-endpoints.feature`

3. **Look for syntax highlighting**:
   - Feature and Scenario lines should be highlighted
   - Step keywords should be colored differently

4. **Test auto-completion**:
   - Type "Fea" and see if "Feature:" appears as a suggestion
   - Type "Giv" and see if "Given" appears as a suggestion

## 🔍 Troubleshooting

### If syntax highlighting doesn't work:
1. **Check file association**:
   - Right-click on `.feature` file
   - Select "Change Language Mode"
   - Choose "Gherkin" or "Cucumber"

2. **Restart VS Code**:
   - Close VS Code completely
   - Reopen the project

3. **Check extension status**:
   - Go to Extensions panel
   - Look for Cucumber extension
   - Ensure it's enabled

### If extension not found:
1. **Try alternative names**:
   - "Gherkin"
   - "BDD"
   - "Feature files"

2. **Check marketplace**:
   - Visit https://marketplace.visualstudio.com/
   - Search for "Cucumber" or "Gherkin"

## 📚 Additional Resources

- **Cucumber Documentation**: https://cucumber.io/docs
- **Gherkin Reference**: https://cucumber.io/docs/gherkin/reference/
- **VS Code Cucumber Extension**: Search in VS Code marketplace

## 🎉 Success Indicators

You'll know everything is working when:
- ✅ `.feature` files have colorful syntax highlighting
- ✅ Gherkin keywords auto-complete
- ✅ You can navigate between features and step definitions
- ✅ VS Code recognizes `.feature` files as Gherkin
- ✅ Cucumber commands appear in the command palette

## 🚀 Next Steps

Once Gherkin support is working:
1. **Write more feature files** for your API endpoints
2. **Use step definition generation** to create Java step definitions
3. **Leverage auto-completion** for faster feature writing
4. **Use navigation features** to jump between features and implementations
