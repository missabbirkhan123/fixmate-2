---
name: Indigo Service Marketplace
colors:
  surface: '#f8f9ff'
  surface-dim: '#cbdbf5'
  surface-bright: '#f8f9ff'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#eff4ff'
  surface-container: '#e5eeff'
  surface-container-high: '#dce9ff'
  surface-container-highest: '#d3e4fe'
  on-surface: '#0b1c30'
  on-surface-variant: '#464555'
  inverse-surface: '#213145'
  inverse-on-surface: '#eaf1ff'
  outline: '#777587'
  outline-variant: '#c7c4d8'
  surface-tint: '#4d44e3'
  primary: '#3525cd'
  on-primary: '#ffffff'
  primary-container: '#4f46e5'
  on-primary-container: '#dad7ff'
  inverse-primary: '#c3c0ff'
  secondary: '#006c49'
  on-secondary: '#ffffff'
  secondary-container: '#6cf8bb'
  on-secondary-container: '#00714d'
  tertiary: '#684000'
  on-tertiary: '#ffffff'
  tertiary-container: '#885500'
  on-tertiary-container: '#ffd4a4'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#e2dfff'
  primary-fixed-dim: '#c3c0ff'
  on-primary-fixed: '#0f0069'
  on-primary-fixed-variant: '#3323cc'
  secondary-fixed: '#6ffbbe'
  secondary-fixed-dim: '#4edea3'
  on-secondary-fixed: '#002113'
  on-secondary-fixed-variant: '#005236'
  tertiary-fixed: '#ffddb8'
  tertiary-fixed-dim: '#ffb95f'
  on-tertiary-fixed: '#2a1700'
  on-tertiary-fixed-variant: '#653e00'
  background: '#f8f9ff'
  on-background: '#0b1c30'
  surface-variant: '#d3e4fe'
typography:
  display-lg:
    fontFamily: Inter
    fontSize: 48px
    fontWeight: '700'
    lineHeight: '1.2'
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Inter
    fontSize: 32px
    fontWeight: '600'
    lineHeight: '1.25'
    letterSpacing: -0.01em
  headline-md:
    fontFamily: Inter
    fontSize: 24px
    fontWeight: '600'
    lineHeight: '1.3'
  body-lg:
    fontFamily: Inter
    fontSize: 18px
    fontWeight: '400'
    lineHeight: '1.5'
  body-md:
    fontFamily: Inter
    fontSize: 16px
    fontWeight: '400'
    lineHeight: '1.5'
  body-sm:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '400'
    lineHeight: '1.5'
  label-md:
    fontFamily: Inter
    fontSize: 14px
    fontWeight: '500'
    lineHeight: '1'
    letterSpacing: 0.01em
  label-sm:
    fontFamily: Inter
    fontSize: 12px
    fontWeight: '600'
    lineHeight: '1'
  headline-lg-mobile:
    fontFamily: Inter
    fontSize: 28px
    fontWeight: '600'
    lineHeight: '1.3'
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  unit: 4px
  container-max: 1280px
  gutter: 24px
  sidebar-width: 280px
  sidebar-collapsed: 80px
  margin-mobile: 16px
  margin-desktop: 32px
---

## Brand & Style
The design system is engineered for a high-trust service marketplace, balancing the efficiency of a SaaS platform with the clarity of a transactional hub. The aesthetic is **Corporate Modern**, leaning into clean lines, purposeful whitespace, and a systematic approach to information density.

The target audience consists of both service providers and enterprise clients who require a reliable, high-performance environment to manage complex workflows. The UI evokes a sense of calm authority and precision, utilizing subtle depth and a refined color palette to guide users through the service lifecycle without visual fatigue.

## Colors
The palette is anchored by **Deep Indigo**, used for primary actions and brand presence to signify stability and intelligence. **Clean Teal** serves as the success indicator, highlighting approved states and growth. An auxiliary **Amber** is used for pending states to maintain urgency without alarm.

### Light Mode
Uses a layered grayscale starting from white (`#FFFFFF`) for cards and `Slate-50` for base backgrounds. Borders use `Slate-200` to maintain a soft, professional structure.

### Dark Mode
Transitions to a deep navy foundation. Surfaces use `Slate-800` while the base background sits at `Slate-900`. High-contrast text utilizes `Slate-50` to ensure maximum legibility against the dark canvas.

## Typography
This design system utilizes **Inter** exclusively to leverage its exceptional legibility and systematic weight distribution. 

- **Weight Strategy:** Use *SemiBold (600)* for headers to establish clear hierarchy and *Medium (500)* for interactive labels. *Regular (400)* is reserved for body copy to ensure a comfortable reading rhythm.
- **Scale:** The system follows a modular scale. For mobile views, large headlines should downscale to the `mobile` variants to prevent excessive line-breaking.
- **Micro-copy:** Use `label-sm` with increased letter spacing for category tags and status badges to differentiate them from standard body text.

## Layout & Spacing
The layout relies on a **Fluid Grid** with a fixed maximum container width for dashboard content. 

- **Rhythm:** An 8px/4px base grid governs all spatial relationships.
- **Sidebar:** The primary navigation is a persistent left-hand sidebar. It should utilize a "collapsed" state on smaller viewports (tablet) and transition to a bottom-bar or hamburger menu on mobile.
- **Data Density:** Dashboard cards use 24px internal padding to provide "breathing room" around data-rich tables and charts.
- **Breakpoints:**
  - Mobile: < 640px (Single column)
  - Tablet: 640px - 1024px (Reduced sidebar, 2-column cards)
  - Desktop: > 1024px (Full sidebar, 3-4 column grid)

## Elevation & Depth
This design system uses **Ambient Shadows** to create a sense of organized layering. 

- **Level 0 (Base):** Flat. Background colors only. Used for the main canvas.
- **Level 1 (Cards/Elements):** A very soft, multi-layered shadow (e.g., `0px 1px 3px rgba(0,0,0,0.1), 0px 1px 2px rgba(0,0,0,0.06)`). This is the default state for all marketplace cards.
- **Level 2 (Hover/Active):** An increased blur and slightly higher spread to indicate interactivity when hovering over clickable cards.
- **Level 3 (Modals/Popovers):** Higher vertical offset and diffusion to pull the element significantly forward from the UI.

In Dark Mode, elevation is communicated via **Tonal Layers** (lighter gray fills for higher elevation) rather than shadows, which become nearly invisible.

## Shapes
The shape language is characterized by **Rounded (lg)** corners. 

- **Components:** Buttons, Input Fields, and Cards all use a standard `0.5rem` (8px) radius. 
- **Large Elements:** Main dashboard containers or featured promotional banners should use `1rem` (16px) to feel more inviting.
- **Icons:** Use a consistent 1.5px or 2px stroke weight with slightly rounded caps to match the UI's geometry. Avoid sharp-edged icons.

## Components

### Buttons
- **Primary:** Solid Deep Indigo with white text. High contrast, 8px rounded corners.
- **Secondary:** Transparent with Indigo border or light gray fill for "Cancel" or "Back" actions.
- **Success:** Solid Teal, reserved specifically for "Approve," "Complete," or "Accept" actions.

### Status Badges (The "Signal" System)
Badges use a "soft pill" style (light background tint with high-contrast text):
- **Pending:** Amber background (10% opacity) with dark Amber text.
- **Approved:** Teal background (10% opacity) with dark Teal text.
- **Rejected:** Rose background (10% opacity) with dark Rose text.

### Cards
Cards are the primary vehicle for marketplace listings. They must include:
- A clear title (`headline-md`).
- A metadata row (price, duration, rating) using `label-md`.
- A subtle `Level 1` shadow and 1px `Slate-200` border.

### Sidebar Navigation
The sidebar should use a dark theme even in light mode to provide a "frame" for the content. Active states are indicated by a 4px vertical Indigo bar on the left edge and a subtle background highlight.

### Input Fields
Bordered style using `Slate-300`. On focus, the border transitions to `Indigo-500` with a soft 3px outer glow (Indigo at 10% opacity).